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
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    
    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            map[i] = board[i].toCharArray();
        }
    
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]=='R') answer = bfs(i,j);
            }
        }
        
        return answer;
    }
    
    public int bfs(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.offer(new Point(r,c, 0));
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            if(map[p.r][p.c]=='G') return p.count;
            
            for(int d=0; d<4; d++) {
                int nr = p.r;
                int nc = p.c;
                
                while(nr>=0 && nr<n && nc>=0 && nc<m  && map[nr][nc] != 'D') {
                    int nextR = nr + dr[d];
                    int nextC = nc + dc[d];
                    nr = nextR;
                    nc = nextC;
                }
                
                nr -= dr[d];
                nc -= dc[d];
                
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc, p.count+1));     
                }
            }
        }
        
        return -1;
    }
    
    public void printInfo() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
    }
}

