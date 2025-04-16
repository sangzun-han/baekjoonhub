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
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static char[][] map;
    static int n,m;
    static boolean[][] visited;
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            map[i] = maps[i].toCharArray();    
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]!='X' && !visited[i][j]) {
                    int food = bfs(i,j);
                    if(food != 0) list.add(food);
                }
            }
        }
        
        if(list.size()==0) return new int[]{-1};
        int[] answer = new int[list.size()];
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public int bfs(int r, int c) {
        int food = Integer.parseInt(String.valueOf(map[r][c]));
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(r,c));
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && map[nr][nc] != 'X') {
                    food += Integer.parseInt(String.valueOf(map[nr][nc]));
                    queue.offer(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return food;
    }
}