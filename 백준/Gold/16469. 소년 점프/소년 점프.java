import java.io.*;
import java.util.*;

class Point {
    int r, c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int R, C;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] map;
    static int[][][] rapperDist;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        rapperDist = new int[3][R][C];

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < R; i++) Arrays.fill(rapperDist[k][i], INF);
        }

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        Point nucksal = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        st = new StringTokenizer(br.readLine());
        Point swings = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        st = new StringTokenizer(br.readLine());
        Point changmo = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        bfs(nucksal, 0);
        bfs(swings, 1);
        bfs(changmo, 2);

        int bestTime = INF;
        int count = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                // 셋 중 하나라도 도달 불가면 skip
                if (rapperDist[0][i][j] == INF ||
                    rapperDist[1][i][j] == INF ||
                    rapperDist[2][i][j] == INF) continue;

                int maxTime = Math.max(rapperDist[0][i][j],
                                Math.max(rapperDist[1][i][j], rapperDist[2][i][j]));

                if (maxTime < bestTime) {
                    bestTime = maxTime;
                    count = 1;
                } else if (maxTime == bestTime) {
                    count++;
                }
            }
        }

        if (bestTime == INF) {
            System.out.println(-1);
        } else {
            System.out.println(bestTime);
            System.out.println(count);
        }
    }

    public static void bfs(Point start, int idx) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];

        queue.offer(start);
        visited[start.r][start.c] = true;
        rapperDist[idx][start.r][start.c] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == '1') continue; // 벽이면 못 감

                visited[nr][nc] = true;
                rapperDist[idx][nr][nc] = rapperDist[idx][p.r][p.c] + 1;
                queue.offer(new Point(nr, nc));
            }
        }
    }
}