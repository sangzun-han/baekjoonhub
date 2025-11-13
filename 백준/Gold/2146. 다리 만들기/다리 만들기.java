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
    static int N;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static List<Point>[] border;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][N];
        int 섬번호 = 2; // 섬 번호는 2부터 시작 (1은 이미 육지를 의미하기 때문)

        // 1. 섬 라벨링 (BFS)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    섬모으기(i, j, visited, 섬번호);
                    섬번호++;
                }
            }
        }

        int islandCount = 섬번호 - 1;

        // 2. 각 섬의 경계 수집
        collectBorders(islandCount);

        // 3. 다리 최단거리 BFS
        int answer = Integer.MAX_VALUE;

        for (int island = 2; island <= islandCount; island++) {
            answer = Math.min(answer, bfsBridge(island));
        }

        System.out.println(answer);
    }

    // ----------------------------------------------------
    // 1) 섬 라벨링 BFS
    // ----------------------------------------------------
    public static void 섬모으기(int r, int c, boolean[][] visited, int number) {
        Queue<Point> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.offer(new Point(r, c));
        map[r][c] = number;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (!visited[nr][nc] && map[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        map[nr][nc] = number;
                        queue.offer(new Point(nr, nc));
                    }
                }
            }
        }
    }

    // ----------------------------------------------------
    // 2) 경계 수집
    // ----------------------------------------------------
    public static void collectBorders(int islandCount) {
        border = new ArrayList[islandCount + 1];

        for (int i = 0; i <= islandCount; i++) {
            border[i] = new ArrayList<>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] >= 2) {
                    if (isBorder(r, c)) {
                        border[map[r][c]].add(new Point(r, c));
                    }
                }
            }
        }
    }

    public static boolean isBorder(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

            if (map[nr][nc] == 0) return true; // 바다와 맞닿은 육지는 경계
        }
        return false;
    }

    // ----------------------------------------------------
    // 3) 경계에서 BFS로 최단 다리 길이 구하기
    // ----------------------------------------------------
    public static int bfsBridge(int island) {
        Queue<Point> q = new ArrayDeque<>();
        int[][] dist = new int[N][N];

        for (int[] row : dist) Arrays.fill(row, -1);

        // 해당 섬의 모든 경계를 시작점으로 이용
        for (Point p : border[island]) {
            q.offer(p);
            dist[p.r][p.c] = 0;
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                // 다른 섬 도착 → 다리 완성
                if (map[nr][nc] >= 2 && map[nr][nc] != island) {
                    return dist[p.r][p.c];
                }

                // 바다(0)로 확장
                if (map[nr][nc] == 0 && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[p.r][p.c] + 1;
                    q.offer(new Point(nr, nc));
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}