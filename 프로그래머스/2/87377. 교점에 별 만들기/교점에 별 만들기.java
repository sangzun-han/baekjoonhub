import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        StringBuilder sb = new StringBuilder();
       
        int maxRow = Integer.MIN_VALUE, maxCol = Integer.MIN_VALUE;
        int minRow = Integer.MAX_VALUE, minCol = Integer.MAX_VALUE;
        
        List<int[]> points = new ArrayList<>();
        
        int size = line.length;
        
        for(int i=0; i<size; i++) {
            for(int j=i+1; j<size; j++) {
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];
                
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                
                long deno = A*D - B*C;
                
                long x1 = B*F - E*D;
                long y1 = E*C - A*F;
                if(deno == 0) continue;
            
                if(x1 % deno == 0 && y1 % deno == 0) {
                    int x = (int) (x1 / deno);       
                    int y = (int) (y1 / deno);
                    points.add(new int[]{x,y});
                    
                    maxRow = Math.max(maxRow, x);
                    minRow = Math.min(minRow, x);
                    maxCol = Math.max(maxCol, y);
                    minCol = Math.min(minCol, y);
                }
            }
        }
        
        if (points.isEmpty()) {
            return new String[]{""};
        }
        int row = maxRow - minRow + 1;
        int col = maxCol - minCol + 1;
        
        char[][] board = new char[row][col];
        for(char[] b: board) {
            Arrays.fill(b, '.');
        }
        
        for(int[] point: points) {
            int r = point[0] - minRow;
            int c = point[1] - minCol;
            board[r][c] = '*';
        }
        String[] answer = new String[col];
        
        int index = 0;
        for(int i=col-1; i>=0; i--) {
            for(int j=0; j<row; j++) {
               sb.append(board[j][i]);
            }
            answer[index++] = sb.toString();
            sb.setLength(0);
        }
        
       
        return answer;
    }
}
