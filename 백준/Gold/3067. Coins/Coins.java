import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[10001];
            int[] coins = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            dp[0] = 1;

            for(int coin: coins) {
                for(int j=coin; j<=m; j++) {
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
            sb.append(dp[m]).append("\n");
        }

        System.out.println(sb);
    }
}

