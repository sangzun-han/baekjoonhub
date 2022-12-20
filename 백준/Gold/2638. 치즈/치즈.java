import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[][] check;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Point {
        int x,y;

        Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        int count = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(checkCount()!=0){
            count++;
            bfs(0,0);
            changeMap();
        }

        System.out.println(count);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        check = new int[N][M];
        visited = new boolean[N][M];
        queue.offer(new Point(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int d=0; d<4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]) {
                    if(map[nx][ny] == 0) {
                        queue.offer(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }
                    if(map[nx][ny]==1) check[nx][ny] +=1;
                }
            }
        }
    }

    private static void changeMap() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(check[i][j] >= 2) map[i][j] = 0;
            }
        }
    }

    private static int checkCount() {
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]>0) count++;
            }
        }
        return count;
    }
}