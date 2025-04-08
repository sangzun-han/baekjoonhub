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

class Solution {
    static int n,m;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        int answer = bfs(0,0, maps);
        return answer== -1 ? -1 : answer + 1;
    }
    
    private static int bfs(int r, int c, int[][] maps) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new Point(r,c,0));
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            if(p.r == n-1 && p.c == m-1) {
                return p.count;
            }
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                int nextCount = p.count + 1;
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && maps[nr][nc]==1) {
                    queue.offer(new Point(nr,nc, nextCount));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1;
        
    }
}