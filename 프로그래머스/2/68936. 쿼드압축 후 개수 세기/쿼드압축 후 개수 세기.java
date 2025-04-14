class Solution {
    static int one = 0;
    static int zero = 0;
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = arr.length;
        recursive(0, 0, n, arr);
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }
    
    public void recursive(int row, int col, int size, int[][] arr) {
        if(check(row, col, size, arr)) {
            if(arr[row][col]==0) zero++;
            if(arr[row][col]==1) one++;
            return;
        }
        
        int half = size / 2;
		recursive(row, col, half, arr);
		recursive(row, col+half, half, arr);
		recursive(row+half, col, half, arr);
		recursive(row+half, col+half, half, arr);
    }
    
    public boolean check(int row, int col, int size, int[][] arr) {
        int base = arr[row][col];
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(arr[i][j] != base) return false;
            }
        }
        return true;
    }
}