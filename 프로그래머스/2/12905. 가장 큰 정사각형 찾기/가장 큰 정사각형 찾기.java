class Solution {
    public int solution(int [][]board){
        int answer = -1;
        int n = board.length;
        int m = board[0].length;
        int[][] d = new int[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j]==1) {
                    if(i==0 || j==0) d[i][j] = 1;
                    else d[i][j] = Math.min(Math.min(d[i-1][j], d[i][j-1]), d[i-1][j-1]) + 1;
                } 
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                answer = Math.max(answer, d[i][j]);
            }
        }
        return answer*answer;
    }
}