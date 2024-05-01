import java.io.*;
import java.util.*;


public class Main {
    static class Point {
        int x,y,dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,T;
    static int[][] map;
    static int[][] saveMap;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        saveMap = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 무기 생각안하고 그냥 공주한테 도달할 수 있는지 보기
        bfs(0,0,0);
        int noGramDist = saveMap[N-1][M-1];
        visited = new boolean[N][M];


        // 그람 위치 알아내기
        Point gramPoint = noGramBFS(0,0,0);

        // 그람은 못줍고 그냥 갔을때도 공주한테도 못감
        if(gramPoint.x == -1 && saveMap[N-1][M-1]==0) {
            System.out.println("Fail");
            return;
        }
        // 그람은 못주었는데 그람 없이 공주까지 도달이 가능함
        else if(gramPoint.x == -1 && saveMap[N-1][M-1]!=0) {
            // T시간 내에 도달
            if(saveMap[N-1][M-1] <= T) {
                System.out.println(saveMap[N-1][M-1]);
            } else {
                System.out.println("Fail");
            }
            return;
        }

        // 그람위치에서 시작해서 공주까지 도달해보기
        visited = new boolean[N][M];
        saveMap = new int[N][M];
        gramBFS(gramPoint.x, gramPoint.y, gramPoint.dist);

        // 그람을 주워서 이동 vs 그냥 이동한거 비교
        int minDist = Math.min(saveMap[N-1][M-1], noGramDist);

        if(noGramDist!=0 && saveMap[N-1][M-1]!=0) {
            if(minDist <= T) {
                System.out.println(minDist);
            } else {
                System.out.println("Fail");
            }

        } else if(noGramDist==0 && saveMap[N-1][M-1] != 0) {
            if(saveMap[N-1][M-1] <= T) {
                System.out.println(saveMap[N-1][M-1]);
            } else {
                System.out.println("Fail");
            }
        } else if(noGramDist!=0 && saveMap[N-1][M-1]==0){
            if(noGramDist <= T) {
                System.out.println(noGramDist);
            } else {
                System.out.println("Fail");
            }
        }
    }

    private static void bfs(int x, int y, int dist) {
        Queue<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(x,y,dist));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int d=0; d<4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny]==0) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx,ny,p.dist+1));
                    saveMap[nx][ny] = p.dist+1;
                }
            }


        }
    }

    private static Point noGramBFS(int x, int y, int dist) {
        Queue<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(x,y,dist));
        visited[x][y] = true;

        int gramX = -1;
        int gramY = -1;
        int gramDist = -1;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int d=0; d<4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && (map[nx][ny]==0 || map[nx][ny]==2)) {
                    if(map[nx][ny]==2){
                        gramX = nx;
                        gramY = ny;
                        gramDist = p.dist+1;
                    }

                    queue.offer(new Point(nx,ny,p.dist+1));
                    visited[nx][ny] = true;
                }
            }
        }

        return new Point(gramX, gramY, gramDist);

    }

    private static void gramBFS(int x, int y, int dist) {
        Queue<Point> queue = new ArrayDeque<>();

        queue.offer(new Point(x,y,dist));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int d=0; d<4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && (map[nx][ny]==0 || map[nx][ny]==1)) {
                    queue.offer(new Point(nx,ny,p.dist+1));
                    visited[nx][ny] = true;
                    saveMap[nx][ny] = p.dist+1;
                }
            }
        }


    }
}
