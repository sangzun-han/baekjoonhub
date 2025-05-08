import java.io.*;
import java.util.*;

class Point {
    int r;
    int c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static char[][] town;
    static int N, M;
    static List<Point> possiblePoison = new ArrayList<>();
    static List<Point> selected = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static int totalTown = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        town = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                town[i][j] = s.charAt(j);
                if (town[i][j] == '0') {
                    possiblePoison.add(new Point(i, j));
                }
            }
        }
        totalTown = N * M - possiblePoison.size();
        
        comb(0, 0);
        System.out.println(answer);
    }

    public static void comb(int index, int count) {
        if (count == 2) {
            answer = Math.min(bfs(), answer);
            return;
        }

        for (int i = index; i < possiblePoison.size(); i++) {
            selected.add(possiblePoison.get(i));
            comb(i + 1, count + 1);
            selected.remove(selected.size() - 1);
        }
    }

    public static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];


        char[][] copy = new char[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = town[i].clone();
        }

        for (Point p : selected) {
            queue.offer(p);
            visited[p.r][p.c] = true;
        }

        int time = 0;
        int infected = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    if (town[nr][nc] == '1') infected++;
                    queue.offer(new Point(nr, nc));
                }
            }
            time++; 
            if (infected == totalTown) return time;
        }


        return time;
    }
}
