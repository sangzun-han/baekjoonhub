class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        boolean[][] isPuddle = new boolean[n][m];
        int[][] d = new int[n][m];
        for(int[] puddle: puddles) {
            int r = puddle[0]-1;
            int c = puddle[1]-1;
            isPuddle[c][r] = true;
        }
        
        for(int i=0; i<n; i++) {
            if(isPuddle[i][0]) break;
            d[i][0] = 1;
        }
        
        for(int i=0; i<m; i++) {
            if(isPuddle[0][i]) break;
            d[0][i] = 1;
        }
        
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(isPuddle[i][j]) d[i][j] = 0;
                else d[i][j] = (d[i-1][j]+d[i][j-1])%1000000007;
            }
        }
        
        return d[n-1][m-1];
    }
}