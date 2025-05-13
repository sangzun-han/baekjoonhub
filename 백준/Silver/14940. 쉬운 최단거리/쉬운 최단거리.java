import java.io.*;
import java.util.*;

class Point {
    int r;
    int c;
    int count;
    
    Point(int r, int c, int count) {
        this.r = r;
        this.c = c;
        this.count = count;
    }
}

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        
        int startX = 0;
        int startY = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        bfs(startX, startY);
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]!=0 && !visited[i][j]) map[i][j] = -1;
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void bfs(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(r,c,0));
        visited[r][c] = true;
        map[r][c] = 0;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && map[nr][nc] != 0) {
                    queue.offer(new Point(nr,nc, p.count+1));
                    map[nr][nc] = p.count+1;
                    visited[nr][nc] = true;
                }
            }
        }
    }
    
  
}
