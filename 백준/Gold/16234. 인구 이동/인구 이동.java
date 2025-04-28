import java.util.*;
import java.io.*;

class Point {
    int r;
    int c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N,L,R;
    static int[][] maps;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static boolean[][] visited;
    static boolean flag = false;
    static int answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        maps = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            visited = new boolean[N][N];
            flag = false;
            // 국경이 열리는 곳 찾기
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j])  bfs(i,j);
                }
            }

            if(!flag) break;
            answer++;

        }
        System.out.println(answer);
    }

    public static void bfs(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        List<Point> list = new ArrayList<>();
        queue.offer(new Point(r,c));
        visited[r][c] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            list.add(new Point(p.r, p.c));
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
                    if(Math.abs(maps[nr][nc] - maps[p.r][p.c]) >= L && Math.abs(maps[nr][nc] - maps[p.r][p.c]) <= R) {
                        queue.offer(new Point(nr,nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        if(list.size() > 1) {
            flag = true;
            int sum = 0;
            for (Point p : list) {
                sum += maps[p.r][p.c];
            }
            int avg = sum / list.size();
            for (Point p : list) {
                maps[p.r][p.c] = avg;
            }
        }
    }
}
