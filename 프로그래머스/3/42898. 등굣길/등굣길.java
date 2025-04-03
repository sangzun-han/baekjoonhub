class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        boolean[][] isPuddle = new boolean[n][m];
        
        for(int[] puddle: puddles) {
            int c = puddle[0]-1;
            int r = puddle[1]-1;
            isPuddle[r][c] = true;    
        }
        
        for(int i=0; i<m; i++) {
            if(isPuddle[0][i]) break;
            else dp[0][i] = 1;
        }
        
        for(int i=0; i<n; i++) {
            if(isPuddle[i][0]) break;
            else dp[i][0] = 1;
        }
        
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(isPuddle[i][j]) dp[i][j] = 0;
                else dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007;
            }
        }
        
        
        return dp[n-1][m-1];
    }
}