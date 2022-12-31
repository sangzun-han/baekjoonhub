import java.io.*;
import java.util.*;

public class Main {
    static int K,W,H;
    static int[] dx = {-1,0,1,0,-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {0,1,0,-1,1,2,2,1,-1,-2,-2,-1};
    static int[] knight = {0,0,0,0,1,1,1,1,1,1,1,1};
    static int[][] map;
    static int[][][] ans;
    static class Point {
        int x,y,k;

        Point(int x, int y,int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        ans = new int[H][W][K+1];

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                Arrays.fill(ans[i][j],-1);
            }
        }

        for(int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0,0에서 출발
        bfs(0,0,0);

        int answer = -1;
        for(int i=0; i<=K; i++) {
            if(ans[H-1][W-1][i] == -1) continue;
            if(answer==-1 || answer > ans[H-1][W-1][i]) {
                answer = ans[H-1][W-1][i];
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y, int k) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x,y,k));
        ans[x][y][k] = 0;
        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int d=0; d<12; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                int nc = p.k + knight[d];

                if(nx>=0 && nx<H && ny>=0 && ny<W) {
                    if(map[nx][ny]==1) continue;
                    if(nc<=K) {
                        if(ans[nx][ny][nc]==-1) {
                            ans[nx][ny][nc] = ans[p.x][p.y][p.k] +1;
                            queue.offer(new Point(nx,ny,nc));
                        }
                    }
                }
            }
        }
    }
}