import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (a,b) -> {
            if(a[col-1] == b[col-1]) return b[0] - a[0];
            else return a[col-1] - b[col-1];
        });
        
        for(int i=row_begin-1; i<row_end; i++) {
            int sum = 0;
            for(int j=0; j<data[i].length; j++) {
                sum += data[i][j] % (i+1);
            }
            answer = answer ^ sum;
        }
        
        return answer;
    }
}