import java.io.*;
import java.util.*;

//        d[i][j] = "도시 i에 도착했을 때 j개의 도시를 경유하여 얻을 수 잇는 기내식 점수의 최대 합"
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] edge = new int[N+1][N+1];

        for(int[] row: edge) Arrays.fill(row,-1);

        for(int i=0; i<K; i++)  {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a<b) edge[a][b] = Math.max(edge[a][b],c);

        }


        int[][] dp = new int[N+1][M+1];

        for(int[] row: dp) Arrays.fill(row,-1);

        dp[1][1] = 0;

        int ans = -1;
        for(int i=1; i<N; i++) {
            for(int j=1; j<M; j++) {
                // 최초 한번 조건에 걸림
                if (dp[i][j] == -1) continue;

                for(int next=i+1; next<=N; next++) {
                    // 갈수있는 길이 없음
                    if(edge[i][next]==-1) continue;

                    // next에서 시작해서 j+1개의 도시를 경유해서 얻을 수 있는 기내식 점수의 최대의 합은
                    // db[next][j+1] 이던가 dp[i][j] + edge[i][next] (i부터 j개의 도시를 경유해서 얻을 수 있는 최대값 + i에서 next까지 의 합)

                    dp[next][j+1]= Math.max(dp[next][j+1], dp[i][j] + edge[i][next]);

                }
            }
        }

        for(int i=1; i<=M; i++) {
            ans = Math.max(ans, dp[N][i]);
        }

        System.out.println(ans);



    }
}





