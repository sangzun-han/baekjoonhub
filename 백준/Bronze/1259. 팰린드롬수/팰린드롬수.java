import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            if(s.equals("0")) return;
            char[] c = s.toCharArray();
            int start = 0;
            int last = c.length-1;
            int cnt = 0;
            while(start!=last && start<=last && last>=0) {
                if(c[start]==c[last]) {
                    start++;
                    last--;
                    cnt++;
                } else {
                    System.out.println("no");
                    break;
                }
            }
            if(c.length%2==0 && cnt==c.length/2) {
                System.out.println("yes");
            } else if(c.length%2==1 && cnt==c.length/2){
                System.out.println("yes");
            }
        }
    }
}