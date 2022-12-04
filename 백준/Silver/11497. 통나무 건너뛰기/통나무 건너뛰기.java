import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums);
            int[] sort = new int[N];
            int left = 0;
            int right = N-1;
            for(int i=0; i<N; i++) {
                if(i%2==0)  sort[left++] = nums[i];
                else sort[right--] = nums[i];
            }

            int ans = -1;
            for(int i=0; i<N-1; i++) {
                ans = Math.max(ans, Math.abs(sort[i] - sort[i+1]));
            }
            ans = Math.max(ans, Math.abs(sort[0] - sort[N-1]));

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}