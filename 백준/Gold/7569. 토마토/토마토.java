import java.io.*;
import java.util.*;

class Point {
    int h;
    int r;
    int c;
    
    public Point(int h, int r, int c) {
        this.h = h;
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int M,N,H;
    static boolean[][][] visited;
    static int[][][] tomato;
    static int[] dr = {0,1,0,-1,0,0};
    static int[] dc = {1,0,-1,0,0,0};
    static int[] dh = {0,0,0,0,1,-1};
    static Queue<Point> queue = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        tomato = new int[H][N][M];
        boolean 토마토다익음 = true;
        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++) {
                    int status = Integer.parseInt(st.nextToken());
                    tomato[h][n][m] = status;
                    if(status==0) 토마토다익음 = false;
                    if(status==1) queue.offer(new Point(h,n,m));
                }
            }
        }
        
        if(토마토다익음) {
            System.out.println(0);
            return;
        }
        
        bfs();
        int answer = 0;
        
        for(int h=0; h<H; h++) {
            for(int n=0; n<N; n++) {
                for(int m=0; m<M; m++) {
                    if(tomato[h][n][m]==0) {
                        System.out.println(-1);
                        return;
                    } else {
                        answer=  Math.max(answer,tomato[h][n][m]);
                    }
                }
            }
        }
        
        System.out.println(answer-1);
    }
    
    public static void bfs() {
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int d=0; d<6; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                int nh = p.h + dh[d];
                
                if(nr>=0 && nr<N && nc>=0 && nc<M && nh>=0 && nh<H) {
                    if(tomato[nh][nr][nc]==0) {
                        queue.offer(new Point(nh,nr,nc));
                        tomato[nh][nr][nc] = tomato[p.h][p.r][p.c] + 1;
                    } 
                }
                
            }
        }
    }
}
