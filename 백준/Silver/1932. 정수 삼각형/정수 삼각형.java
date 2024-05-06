import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        dp[0][0] = triangle[0][0];

        for(int i=1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0) {
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                } else if(j==i) {
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }
                 else {
                     dp[i][j] = Math.max(triangle[i][j] + dp[i-1][j], triangle[i][j]+ dp[i-1][j-1]);
                }
            }

        }

        int ans = -1;
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, dp[n-1][i]);
        }
        System.out.println(ans);
    }
}

