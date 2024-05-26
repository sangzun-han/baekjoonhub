import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        int[][][] dp = new int[N + 1][N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 위치 설정
        if (map[1][1] == 0) {
            dp[1][1][0] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1 && j == 1) continue;

                int currentMilk = map[i][j];

                // 딸기우유 (0)
                if (currentMilk == 0) {
                    if (i > 1) dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][2] + 1);
                    if (j > 1) dp[i][j][0] = Math.max(dp[i][j][0], dp[i][j - 1][2] + 1);
                }
                dp[i][j][0] = Math.max(dp[i][j][0], Math.max(dp[i - 1][j][0], dp[i][j - 1][0]));

                // 초코우유 (1)
                if (currentMilk == 1 && (i > 1 && dp[i - 1][j][0] > dp[i - 1][j][1] || j > 1 && dp[i][j - 1][0] > dp[i][j - 1][1])) {
                    if (i > 1) dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j][0] + 1);
                    if (j > 1) dp[i][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][0] + 1);
                }
                dp[i][j][1] = Math.max(dp[i][j][1], Math.max(dp[i - 1][j][1], dp[i][j - 1][1]));

                // 바나나우유 (2)
                if (currentMilk == 2 && (i > 1 && dp[i - 1][j][1] > dp[i - 1][j][2] || j > 1 && dp[i][j - 1][1] > dp[i][j - 1][2])) {
                    if (i > 1) dp[i][j][2] = Math.max(dp[i][j][2], dp[i - 1][j][1] + 1);
                    if (j > 1) dp[i][j][2] = Math.max(dp[i][j][2], dp[i][j - 1][1] + 1);
                }
                dp[i][j][2] = Math.max(dp[i][j][2], Math.max(dp[i - 1][j][2], dp[i][j - 1][2]));
            }
        }

        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans = Math.max(ans, dp[N][N][i]);
        }

        System.out.println(ans);
    }
}
