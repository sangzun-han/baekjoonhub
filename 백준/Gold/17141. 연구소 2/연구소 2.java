import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x,y,time;

        Point(int x,int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int N,M;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static boolean[] virus_visited;
    static int[] virus;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Point> list = new ArrayList<>();
    static int max = -1;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        copyMap = new int[N][N];
        visited = new boolean[N][N];
        virus = new int[M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    list.add(new Point(i,j,0));
                }
            }
        }
        virus_visited = new boolean[list.size()];

        comb(0,0);

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static void comb(int cnt,int start) {
        if(cnt==M) {
           bfs();
           return;
        }

        for(int i=start; i<list.size(); i++) {
            if(!virus_visited[i]) {
                virus[cnt] = i;
                virus_visited[i] = true;
                comb(cnt+1, i+1);
                virus_visited[i] = false;
            }
        }
    }

    private static void bfs() {
        max = -1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==2) copyMap[i][j]=0;
                else copyMap[i][j] = map[i][j];
            }
        }

        visited = new boolean[N][N];

        Queue<Point> queue = new ArrayDeque<>();

        for(int i=0; i<M; i++) {
            queue.offer(list.get(virus[i]));
            int x = list.get(virus[i]).x;
            int y = list.get(virus[i]).y;
            copyMap[x][y] = 2;
        }

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            max = Math.max(max, p.time);
            for(int d=0; d<4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && copyMap[nx][ny]==0) {
                    visited[nx][ny] = true;
                    copyMap[nx][ny] = p.time+1;
                    queue.offer(new Point(nx,ny,p.time+1));
                }
            }
        }
        
        if(isPossible()) {
            min = Math.min(max, min);
        }
    }

    private static boolean isPossible() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                if(copyMap[i][j]==0) return false;
            }
        }
        return true;
    }
}
