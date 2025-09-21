import java.io.*;
import java.util.*;

class Point {
    int r,c;
    
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int[] dr = {-1,0,1,0,1,1,-1,-1};
    static int[] dc = {0,1,0,-1,1,-1,1,-1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;
            int[][] map = new int[w][h];
            boolean[][] visited = new boolean[w][h];
            
            for(int i=0; i<w; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<h; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int answer = 0;
            for(int i=0; i<w; i++) {
                for(int j=0; j<h; j++) {
                    if(!visited[i][j] && map[i][j]==1) {
                        bfs(i, j, w, h, map, visited);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
    
    public static void bfs(int r, int c, int R, int C, int[][] map, boolean[][] visited) {
        Queue<Point> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.offer(new Point(r,c));
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int d=0; d<8; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc] && map[nr][nc]==1) {
                    queue.offer(new Point(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
