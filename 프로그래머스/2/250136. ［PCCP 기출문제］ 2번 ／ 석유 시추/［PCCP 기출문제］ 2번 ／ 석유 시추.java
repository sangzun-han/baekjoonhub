import java.util.*;

class Point {
    int r;
    int c;
    
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    static int n,m;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j]==1) {
                    bfs(i, j, land);
                }        
            }
        }
        
        for(int count: map.values()) {
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
    
    public void bfs(int r, int c, int[][] land) {
        int count = 1;
        Set<Integer> set = new HashSet<>();
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(r,c));
        land[r][c] = 0;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            set.add(p.c);
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && land[nr][nc]==1) {
                    queue.offer(new Point(nr,nc));    
                    land[nr][nc] = 0;
                    count++;
                }
            }
        }
        
        for(int col: set) {
            map.put(col, map.getOrDefault(col, 0) + count);
        }
        return;
    }
}