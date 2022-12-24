import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        long ans = Long.MAX_VALUE;
        long ansL = 0;
        long ansR = 0;
        long ansC = 0;

        // k값하나 고정
        for(int k=0; k<N-2; k++) {
            int left = k+1;
            int right = N-1;
            while(left < right && right>=0) {
                long sum = nums[left] + nums[right] + nums[k];
                if(Math.abs(sum) < ans) {
                    ans = Math.abs(sum);
                    ansL = nums[left];
                    ansR = nums[right];
                    ansC = nums[k];
                }
                if(sum < 0) left++;
                else right--;
            }
        }

        long[] ansArr = new long[3];
        ansArr[0] = ansL;
        ansArr[1] = ansR;
        ansArr[2] = ansC;
        Arrays.sort(ansArr);

        for(int i=0; i<3; i++) {
            System.out.print(ansArr[i]+" ");
        }

    }
}