import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] board = new int[rows][columns];
        List<Integer> list = new ArrayList<>();
        
        int num = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                board[i][j] = num++;
            }
        }
        int index = 0;
        
        for(int[] query: queries) {
            int startR = query[0] - 1;
            int startC = query[1] - 1;
            int endR = query[2] - 1;
            int endC = query[3] - 1;
            int LR = Math.abs(endC - startC);
            int UD = Math.abs(endR - startR);
            
            int prev = board[startR][startC];
            int min = prev;
            
       
            for(int i=startC; i<endC; i++) {
                int temp = board[startR][i+1]; // 다음값
                board[startR][i+1] = prev;
                prev = temp;
                min = Math.min(prev, min);
            }
       
            for(int i=startR; i<endR; i++) {
                int temp = board[i+1][endC];
                board[i+1][endC] = prev;
                prev = temp;
                min = Math.min(prev, min);
            }
  
            for (int i=endC; i>startC; i--) {
                int temp = board[endR][i-1];
                board[endR][i-1] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            for (int i=endR; i>startR; i--) {
                int temp = board[i-1][startC];
                board[i-1][startC] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }
            answer[index++] = min;
        }
        
        return answer;
    }
}