import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String target = br.readLine();
        String current = br.readLine();
        
        if(target.equals(current)) {
            System.out.println(0);
            return;
        }
       
        int count1 = go(current.toCharArray(), target.toCharArray(), N, true); 
        int count2 = go(current.toCharArray(), target.toCharArray(), N, false);
        
      
        if(count1==-1 && count2==-1) {
            System.out.println(-1);
        } else if(count1==-1){
            System.out.println(count2);
        } else if(count2==-1){
            System.out.println(count1);
        } else {
            System.out.println(Math.min(count1, count2));
        }
    }
        
    public static int go(char[] current, char[] target, int n, boolean isPass) {
        int count = 0;
        
        if(isPass) {
                count++;
                current[0] = current[0] == '1' ? '0' : '1';
                current[1] = current[1] == '1' ? '0' : '1';
        }
     
        for(int i=1; i<n-1; i++) {
            if(current[i-1] != target[i-1]) {
                count++;
                current[i-1] = current[i-1] == '1' ? '0' : '1';
                current[i] = current[i] == '1' ? '0' : '1';
                current[i+1] = current[i+1] == '1' ? '0' : '1';
            }
        }
        
        if(current[n-1] != target[n-1]) {
            count++;
            current[n-1] = current[n-1] == '1' ? '0' : '1';
            current[n-2] = current[n-2] == '1' ? '0' : '1';
        }
        
        for(int i=0; i<n; i++) {
            if(current[i] != target[i]) {
                return -1;
            }
        }
        
        return count;
        
    }
    
}
