import java.util.*;

class Point {
    int r;
    int c;
    int k;
    StringBuilder s;
    
    Point(int r, int c, int k, StringBuilder s) {
        this.r = r;
        this.c = c;
        this.k = k;
        this.s = s;
    }
}

class Solution {
    static int[] dr = {1,0,0,-1}; // dlru
    static int[] dc = {0,-1,1,0};
    String[] dir = {"d","l","r","u"};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {        
        char[][] map = new char[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = '.';
                
                if(i==x-1 && j==y-1) map[i][j] = 'S';
                if(i==r-1 && j==c-1) map[i][j] = 'E';
            }
        }
        String answer = bfs(map, n, m, x-1, y-1, r-1, c-1, k);
        return answer == null ? "impossible" : answer;
    }
    
    public String bfs(char[][] map, int n, int m, int startX, int startY, int endX, int endY, int k) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][k + 1]; // 방문 체크

        queue.offer(new Point(startX, startY, 0, new StringBuilder("")));
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            int remainingMoves = k - p.k;
            
            int minDistance = Math.abs(p.r - endX) + Math.abs(p.c - endY);
            if (minDistance > remainingMoves) continue;
            
            if(p.k==k && map[p.r][p.c]=='E') {
                return p.s.toString();
            }
            
            for(int d=0; d<4; d++) {  
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc][p.k + 1]) {
                    visited[nr][nc][p.k + 1] = true; // 방문 체크

                    StringBuilder newPath = new StringBuilder(p.s);
                    newPath.append(dir[d]);
                    queue.offer(new Point(nr,nc, p.k+1, newPath));
                    
                }
            }
        }
        return null;
    }
}