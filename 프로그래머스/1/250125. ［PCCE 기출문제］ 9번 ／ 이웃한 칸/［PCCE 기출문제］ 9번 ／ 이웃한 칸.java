class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        int[] dh = {0,1,-1,0};
        int[] dw = {1,0,0,-1};
        
        for(int d=0; d<4; d++) {
            int nh = h+ dh[d];
            int nw = w + dw[d];
            
            if(nw>=0 && nw<n && nh>=0 && nh<n) {
                if(board[h][w].equals(board[nh][nw])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}