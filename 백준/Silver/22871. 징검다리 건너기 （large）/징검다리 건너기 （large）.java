import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 돌의 개수
        long[] nums = new long[N];
        long[] dp = new long[N]; 
        Arrays.fill(dp, Long.MAX_VALUE);
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken()); 
        }

        dp[0] = 0; // 출발 지점 초기화

        for (int i = 0; i < N; i++) { 
            for (int j = i + 1; j < N; j++) {
                long cost = (j - i) * (1 + Math.abs(nums[i] - nums[j]));
                dp[j] = Math.min(dp[j], Math.max(dp[i], cost)); 
            }
        }

        System.out.println(dp[N-1]); // 최종 결과 출력
    }
}


