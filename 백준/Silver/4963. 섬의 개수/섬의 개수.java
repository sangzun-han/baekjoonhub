import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static boolean[][] visited;
    static int w,h;
    static int[] dx = {-1,1,-1,-1,1,1,0,0};
    static int[] dy = {0,0,-1,1,-1,1,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());


            if(w==0 && h==0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];


            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                }
            }
            int count = 0;

            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(map[i][j]==1 && !visited[i][j]) {
                        bfs(i,j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);


    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();


            for(int d=0; d<8; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny]==1 && !visited[nx][ny]) {
                    queue.offer(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
