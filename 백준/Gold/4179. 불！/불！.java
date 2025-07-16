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
    static char[][] map;
    static int[][] fire;
    static int[][] jihun;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Point jihunStart;
    static List<Point> fireStart = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fire = new int[R][C];
        jihun = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == '#') {
                    fire[i][j] = -1;
                    jihun[i][j] = -1;
                } else if (map[i][j] == 'F') {
                    fire[i][j] = 1;
                    fireStart.add(new Point(i,j));
                } else if (map[i][j] == 'J') {
                    jihun[i][j] = 1;
                    jihunStart = new Point(i, j);
                }
            }
        }

        fireBFS();
        jihunBFS(jihunStart.r, jihunStart.c);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 || i == R - 1 || j == 0 || j == C - 1) {
                    if (map[i][j] != '#' && jihun[i][j] != 0 && (fire[i][j] == 0 || jihun[i][j] < fire[i][j])) {
                        answer = Math.min(answer, jihun[i][j]);
                    }
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? "IMPOSSIBLE" : answer);
    }

    public static void fireBFS() {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        for(Point p: fireStart) {
            queue.offer(new Point(p.r, p.c));
            visited[p.r][p.c] = true;
            fire[p.r][p.c] = 1;
        }


        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
                    !visited[nr][nc] && map[nr][nc] != '#') {
                    queue.offer(new Point(nr, nc));
                    visited[nr][nc] = true;
                    fire[nr][nc] = fire[p.r][p.c] + 1;
                }
            }
        }
    }

    public static void jihunBFS(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        visited[r][c] = true;
        queue.offer(new Point(r, c));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
                    !visited[nr][nc] && map[nr][nc] != '#') {
                    if (fire[nr][nc] == 0 || jihun[p.r][p.c] + 1 < fire[nr][nc]) {
                        queue.offer(new Point(nr, nc));
                        visited[nr][nc] = true;
                        jihun[nr][nc] = jihun[p.r][p.c] + 1;
                    }
                }
            }
        }
    }
}
