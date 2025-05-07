import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            st = new StringTokenizer(br.readLine());
    
            for(int i=0; i<N; i++) {
                int num = Integer.parseInt(st.nextToken());
                nums[i] = num;
            }
            
            long sum = go(nums);
            System.out.println(sum);
        }
    }
    
    public static long go(int[] nums) {
        int maxPrice = 0;
        long sum = 0;
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] >= maxPrice) {
                maxPrice = nums[i];
            } else {
                sum += maxPrice - nums[i];
            }
        }
      
        
        return sum;
    }
}


