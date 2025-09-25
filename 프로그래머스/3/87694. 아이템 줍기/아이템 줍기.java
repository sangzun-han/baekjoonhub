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
    static int n,m;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] map = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        n = rectangle.length;
        m = rectangle[0].length;
        
        for (int i = 0; i < n; i++) {
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            for (int y = y1+1; y < y2; y++) {
                for (int x = x1+1; x < x2; x++) {
                    map[y][x] = 0;
                }
            }
        }
        
        int answer = bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);
        return answer / 2;
    }
    
    public static int bfs(int startR, int startC, int endR, int endC) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(startR, startC, 0));
        visited[startR][startC] = true; 
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            if(p.r==endR && p.c==endC) return p.dist;
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<102 && nc>=0 && nc<102) {
                    if(!visited[nr][nc] && map[nr][nc]==1) {
                        visited[nr][nc] = true;
                        queue.offer(new Point(nr,nc,p.dist+1));
                    }
                }
            }
        }
        return 0;
    }
}