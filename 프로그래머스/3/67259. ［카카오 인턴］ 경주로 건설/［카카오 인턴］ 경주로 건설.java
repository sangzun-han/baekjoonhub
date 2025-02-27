import java.util.*;

class Point {
    int r;
    int c;
    int dir;
    int cost;
    
    Point(int r, int c, int dir, int cost) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.cost = cost;
    }
}

class Solution {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[][][] dp = new int[n][n][4];
        
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
 
        bfs(n, board, dp);
        
        
        return Math.min
            (Math.min(dp[n-1][n-1][0], dp[n-1][n-1][1]), 
             Math.min(dp[n-1][n-1][2],dp[n-1][n-1][3]));
    }
    
    public void bfs(int n, int[][] board, int[][][] dp) {
        Queue<Point> queue = new ArrayDeque<>();    
        queue.offer(new Point(0, 0, 0, 0));
        queue.offer(new Point(0, 0, 1, 0));

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr<0 || nr>=n || nc<0 || nc>=n || board[nr][nc]==1) continue;
                
                int newCost = (d%2==p.dir%2) ? p.cost + 100 : p.cost + 600;
                
                if(dp[nr][nc][d] > newCost) {
                    dp[nr][nc][d] = newCost;
                    queue.offer(new Point(nr,nc, d, newCost));
                }
            }
        }
    }
}