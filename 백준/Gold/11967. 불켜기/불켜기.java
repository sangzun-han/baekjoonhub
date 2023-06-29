import java.io.*;
import java.util.*;

class Point {
    int x,y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static boolean[][] lighted;
    static ArrayList<Point>[][] map;
    static int result = 1;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        lighted = new boolean[N][N];
        map = new ArrayList[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            map[x][y].add(new Point(a,b));
        }

        // bfs로 탐색 시작.
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(0, 0));
        visited[0][0] = true;
        lighted[0][0] = true;

        while (!queue.isEmpty()) {
            // 불을 킬 수 있으면 전부 킴
            Point p = queue.poll();

            if (!map[p.x][p.y].isEmpty()) {
                visited = new boolean[N][N];
                visited[p.x][p.y] = true;

                for (Point po : map[p.x][p.y]) {
                    if (!lighted[po.x][po.y]) {
                        lighted[po.x][po.y] = true;
                        result++;
                    }
                }

                map[p.x][p.y].clear();
            }

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && lighted[nx][ny] && !visited[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return result;
    }
}