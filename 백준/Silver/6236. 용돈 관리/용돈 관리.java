import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int[] nums;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        
        int left = 0;
        int right = 0;
        
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        
        int answer = right;
        
        while(left <= right) {
            int mid = (left+right) / 2;
            if(can(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
    
    public static boolean can(int k) {
        int count = 1;
        int money = k;
        
        for(int i=0; i<N; i++) {
            if(money < nums[i]) {
                count++;
                money = k; 
            } 
            money -= nums[i];
            
        }
        
        return count <= M;
    }
    
}
