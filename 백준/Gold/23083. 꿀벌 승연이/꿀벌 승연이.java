import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static long[][] map = new long[1004][1004]; // 벌집
    static long[][] d; // d[i][j] : i,j까지 갈수있는 경우의 수
    static long max = 1000000007;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 모든 첫번째 열이 1이 아닐 수도 있으므로 1,1에서만 1로 초기화 그외에는 모두 계산
        map[1][1] = 1;

        // K개의 구멍 칸
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = -1;
        }

        for(int j=1; j<=M; j++) {
            for(int i=1; i<=N; i++) {
                if(map[i][j]==-1) continue;
                long x = map[i-1][j]%max;
                long y = map[i][j-1]%max;
                long z = 0;
                if(j%2==0) {
                    z = map[i+1][j-1]%max;
                } else {
                    z = map[i-1][j-1]%max;
                }
                if(x!=-1) map[i][j] += x;
                if(y!=-1) map[i][j] += y;
                if(z!=-1) map[i][j] += z;
                map[i][j] %= max;
            }
        }
        System.out.println(map[N][M]);
    }
}