import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = map[0][0];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(i==0 && j==0) continue;
                else if(j==0) dp[i][j] = dp[i-1][j] + map[i][j];

                else if(i==0) dp[i][j] = dp[i][j-1] + map[i][j];

                else dp[i][j] = Math.max(dp[i-1][j] + map[i][j], dp[i][j-1] + map[i][j]);

            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}


// 완전탐색하면 결국 백트랙킹이 되서 시간복잡도가 너무높아짐.
// 결국 완탐을 돌긴해야하는데 이전값의 최대값을 저장하고 가야할듯?
// 그럼 dp로 구현해야하는데  점화식을 세우던가. dfs이용해서 메모제이션해야할듯?
// dp[i][j] : (i,j)까지 이동했을때 최대 사탕 개수