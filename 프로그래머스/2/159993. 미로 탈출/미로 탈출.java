import java.util.*;

class Point {
    int row;
    int col;
    int count;
    
    Point(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }
}

class Solution {
    static char[][] map;
    static int n,m;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public int solution(String[] maps) {
        int answer = 0;
        int startR = 0;
        int startC = 0;
        int leverR = 0;
        int leverC = 0;
        int exitR = 0;
        int exitC = 0;
        
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        
        for(int i=0; i<n; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        for(int i=0; i<n; i++)  {
            for(int j=0; j<m; j++) {
                if(map[i][j]=='S') {
                    startR = i;
                    startC = j;
                }
                
                if(map[i][j]=='L') {
                    leverR = i;
                    leverC = j;
                }
                
                if(map[i][j]=='E') {
                    exitR = i;
                    exitC = j;
                }
            }    
        }
        
        int count = bfs(startR, startC, leverR, leverC);
        if(count == -1) return -1;
        answer += count;
        
        count = bfs(leverR, leverC, exitR, exitC);
        if(count == -1) return -1;
        answer += count;
        
        return answer;
    }
    
    public int bfs(int row1, int col1, int row2, int col2) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        visited[row1][col1] = true;
        queue.offer(new Point(row1, col1, 0));
        
        while(!queue.isEmpty()) {
            
            Point p = queue.poll();
            
            if(p.row==row2 && p.col==col2) return p.count;
            
            for(int d=0; d<4; d++) {
                int nr = p.row + dr[d];
                int nc = p.col + dc[d];
                int nCount = p.count;
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && map[nr][nc] != 'X') {
                    queue.offer(new Point(nr,nc, nCount+1));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1;
        
    }
}
