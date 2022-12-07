import java.io.*;
import java.util.*;

public class Main {
    static int N,M,ans;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    static class Point {
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine());
            ans = 0;
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j]==1 && !visited[i][j]) {
                        bfs(i,j);
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x,y));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int d=0; d<4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx>=0 && nx<M && ny>=0 &&ny<N && !visited[nx][ny] && map[nx][ny]==1) {
                    queue.offer(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}