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
    static boolean[][] visited;
    static int n,m;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j]==1 && !visited[i][j]) {
                    bfs(i,j,land);
                }
            }
        }
        
        for(int key: map.keySet()) {
            answer = Math.max(map.get(key), answer);
        }
        
        return answer;
    }
    
    public void bfs(int r, int c, int[][] land) {
        int count = 0;
        Queue<Point> queue = new ArrayDeque<>();
        List<Integer> cols = new ArrayList<>();
        
        visited[r][c] = true;
        queue.offer(new Point(r,c));
        
        while(!queue.isEmpty()) {
            Point p  = queue.poll();
            count++;
            
            if(!cols.contains(p.y)) cols.add(p.y);
            
            for(int d=0; d<4; d++) {
                int nr = p.x + dr[d];
                int nc = p.y + dc[d];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && land[nr][nc]==1) {
                    queue.offer(new Point(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
        
        for(int col: cols) {
            map.put(col, map.getOrDefault(col, 0) + count);     
        }
       
    }
}