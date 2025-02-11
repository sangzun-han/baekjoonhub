import java.util.*;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static char[][] map;
    static int n,m;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        
        map = new char[n][m];
        
        for(int i=0; i<n; i++) {
            map[i] = storage[i].toCharArray();
        }
        
        for(int i=0; i<requests.length; i++) {
            char c = requests[i].charAt(0);
            if(requests[i].length()==1) removeOne(c);
            else removeAll(c);
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] != '.') answer++;
            }
        }
        
        return answer;
    }
    
    public void removeOne(char target) {
        List<Point> removePoint = new ArrayList<>();
    
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]==target && (isOutside(i,j) || canEscape(i,j))) {
                    removePoint.add(new Point(i,j));
                }
            }
        }
        
        for(Point p: removePoint) {
            map[p.x][p.y] = '.';
        }
    }
    
    public boolean isOutside(int r, int c) {
        if(r==0 || r==n-1 || c==0 || c==m-1) return true;
        return false;
    }
    
    public boolean canEscape(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new Point(r,c));
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nr = p.x + dr[d];
                int nc = p.y + dc[d];
                
                if(nr<0 || nr>=n || nc<0 || nc>=m) return true;
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && map[nr][nc]=='.') {
                    queue.offer(new Point(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return false;
    }
    
    public void removeAll(char target) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]==target) map[i][j]='.';
            }
        }
    }
}