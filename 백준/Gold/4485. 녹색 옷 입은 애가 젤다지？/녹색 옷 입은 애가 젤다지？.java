import java.io.*;
import java.util.*;

class Point {
    int r;
    int c;
    
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 1;
        
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            
            int[][] map = new int[N][N];
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            bfs(N, map, tc);
            tc++;
        }
    }
    
    public static void bfs(int n, int[][] map,int tc) {
        int[][] answer = new int[n][n];
   
        
        for(int i=0; i<n; i++) {
            Arrays.fill(answer[i], 1250);
        }
        
        answer[0][0] = map[0][0];
            
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0,0));
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<n && nc>=0 && nc<n) {
                  
                    if(answer[nr][nc] > answer[p.r][p.c] + map[nr][nc]) {
                        answer[nr][nc] = answer[p.r][p.c] + map[nr][nc];
                        queue.offer(new Point(nr,nc));
                    }
                }
            }
        }
        System.out.printf("Problem %d: %d\n", tc, answer[n-1][n-1]);
    }
}
