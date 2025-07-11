import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][][] d = new int[N][M][2];
        d[0][0][0] = d[0][0][1] = map[0][0];
        
        for(int i=1; i<M; i++) {
            d[0][i][0] = d[0][i-1][0] + map[0][i];
            d[0][i][1] = d[0][i-1][1] + map[0][i];
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(j == 0) d[i][j][0] = Math.max(d[i-1][j][0], d[i-1][j][1]) + map[i][j];
                else d[i][j][0] = Math.max(Math.max(d[i-1][j][0], d[i-1][j][1]), d[i][j-1][0]) + map[i][j];
            }

            for(int j=M-1; j>=0; j--) {
                if(j == M-1) d[i][j][1] = Math.max(d[i-1][j][0], d[i-1][j][1]) + map[i][j];
                else d[i][j][1] = Math.max(Math.max(d[i-1][j][0], d[i-1][j][1]),d[i][j+1][1]) + map[i][j];
            }
        }

        int answer = Math.max(d[N-1][M-1][0], d[N-1][M-1][1]);
        System.out.println(answer);
    }
}