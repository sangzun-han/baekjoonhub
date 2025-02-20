class Solution {
    static int[] queen;
    static int answer;
    public int solution(int n) {
        answer = 0;
        queen = new int[n+1];
        
        backtracking(0, n);
        return answer;
    }
    
    public void backtracking(int row, int n) {
        if(row==n) {
            answer++;
            return;
        }
        
        for(int col=0; col<n; col++) {
            if(isCheck(row,col)) {
                queen[row] = col;
                backtracking(row+1, n);
            }
        }
    }
    
    public boolean isCheck(int row, int col) {
        for(int prevRow=0; prevRow<row; prevRow++) {
            int prevCol = queen[prevRow];
            
            if(prevCol == col) return false;
            
            if(Math.abs(prevRow-row) == Math.abs(prevCol - col)) return false;
        }
        
        return true;
    }
}