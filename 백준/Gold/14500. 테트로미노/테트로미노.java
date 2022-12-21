import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                backtracking(i,j,1, map[i][j]);
                if(j+2<M) {
                    int t = map[i][j] + map[i][j+1] + map[i][j+2];

                    if(i-1>=0) {
                        int t1 = t + map[i-1][j+1];
                        if(t1 > ans) ans = t1;
                    }
                    if(i+1<N) {
                        int t2 = t+ map[i+1][j+1];
                        if(t2 > ans) ans = t2;
                    }
                }

                if(i+2<N) {
                    int t = map[i][j] + map[i+1][j] + map[i+2][j];

                    if(j-1>=0) {
                        int t1 = t + map[i+1][j-1];
                        if(t1 > ans) ans = t1;
                    }

                    if(j+1<M) {
                        int t2 = t + map[i+1][j+1];
                        if(t2 > ans) ans = t2;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static void backtracking(int x, int y, int cnt, int sum) {
        if(cnt==4) {
            if(ans < sum) ans = sum;
            return;
        }
        visited[x][y] = true;
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]) {
                backtracking(nx,ny,cnt+1,sum+map[nx][ny]);
            }
        }
        visited[x][y] = false;
    }
}