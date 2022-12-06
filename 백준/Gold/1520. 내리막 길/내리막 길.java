import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[][] d;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        d = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                d[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));
    }

    private static int dfs(int x, int y) {
        if(x==N-1 && y==M-1) return 1;
        if(d[x][y] != -1) return d[x][y];
        d[x][y] = 0;
        for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=0 & nx<N && ny>=0 && ny<M && map[x][y] > map[nx][ny]) {
                d[x][y] += dfs(nx,ny);
            }
        }

        return d[x][y];

    }
}