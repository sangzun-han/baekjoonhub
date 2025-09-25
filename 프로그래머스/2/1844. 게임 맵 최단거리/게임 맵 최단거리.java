import java.io.*;
import java.util.*;

class Point {
    int r;
    int c;
    int dist;
    
    Point(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}

class Solution {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int n,m;
        
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
    
        int answer = bfs(maps);
        return answer;
    }
    
    public static int bfs(int[][] maps) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new Point(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.r==n-1 && p.c==m-1) return p.dist;
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                int dist = p.dist;
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && maps[nr][nc]==1) {
                    queue.offer(new Point(nr,nc, dist+1));
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
    
  
}