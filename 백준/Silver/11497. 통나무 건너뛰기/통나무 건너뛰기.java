import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] nums = new int[n];
            for(int i=0; i<n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);
            int left = 0;
            int right = n-1;
            int[] newNums = new int[n];
            for(int i=0; i<n; i++) {
                if(i%2==0) newNums[left++] = nums[i];
                else newNums[right--] = nums[i];
            }
            int ans = -1;
            for(int i=0; i<n-1; i++) {
                ans = Math.max(ans, Math.abs(newNums[i+1] - newNums[i]));
            }
            ans = Math.max(ans, Math.abs(newNums[n-1] - newNums[0]));
            System.out.println(ans);
        }
    }
}
