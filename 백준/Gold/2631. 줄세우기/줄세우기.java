import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        int max = -1;


        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j]+1>dp[i]) {
                    dp[i] = dp[j]+1;
                    max = Math.max(max,dp[i]);
                }
            }
        }


        System.out.println(N - max);
    }
}
// dp[i] : i까지 선택했을때 최대 증가 수열길이
// 최대길이에서 최대 증가 수열 길이를 빼면 그게 최소값이 될듯 LIS는 오름차순으로 정렬돼있으니 나머지것들만옮기면 최소값일듯?
