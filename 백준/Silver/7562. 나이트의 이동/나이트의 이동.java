import java.io.*;
import java.util.*;
public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int l;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(x==r && y==c) {
                System.out.println(0);
            } else {
                bfs(x,y);
                System.out.println(map[r][c]);
            }
        }
    }

    private static void bfs(int x, int y) {

        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {

            Point p = queue.poll();
            for (int d = 0; d < 8; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
                    if(map[nx][ny]==0) {
                        map[nx][ny] = map[p.x][p.y]+1;
                        queue.offer(new Point(nx,ny));
                    }
                }
            }
        }
    }
}