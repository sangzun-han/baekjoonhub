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
    static boolean[][] visited;
    static char[][] map;
    static int row;
    static int col;
    
    public int[] solution(String[] maps) {
        
        List<Integer> list = new ArrayList<>();
        row = maps.length;
        col = maps[0].length();
        
        map = new char[row][col];
        visited = new boolean[row][col];
        
        for(int i=0; i<row; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(map[i][j]!='X' && !visited[i][j]) {
                    int eat = bfs(i,j);
                    list.add(eat);
                }
            }
        }
        if(list.size()==0) return new int[]{-1};
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int bfs(int r, int c) {
        int eat = 0;
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(r,c));
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            eat += map[p.r][p.c] - '0';
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<row && nc>=0 && nc<col && !visited[nr][nc] && map[nr][nc]!='X') {
                    queue.offer(new Point(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return eat;
    }
}