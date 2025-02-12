import java.util.*;

class Solution {
    static char[][] boards;
    static int n = 3;
    static int m = 3;
    public int solution(String[] board) {
        int o = 0;
        int x = 0;
        boards = new char[n][m];
        
        for(int i=0; i<board.length; i++) {
            boards[i] = board[i].toCharArray();
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(boards[i][j]=='O') o++;
                else if (boards[i][j]=='X') x++;
            }
        }
        
        boolean oWin = isWin('O');
        boolean xWin = isWin('X');
        if(x > o || o - x > 1) return 0;
        if(oWin && xWin) return 0;
        if(oWin && o != x+1) return 0;
        if(xWin && o != x) return 0;
        return 1;
      
    }
    
    public boolean isWin(char c) {
        for(int i=0; i<n; i++) {
            if(boards[i][0]==c && boards[i][0]==boards[i][1] && boards[i][0]==boards[i][2]) return true;
            if(boards[0][i]==c && boards[0][i]==boards[1][i] && boards[0][i]==boards[2][i]) return true;
        }
        if(boards[0][0]==c && boards[0][0]==boards[1][1] && boards[0][0]==boards[2][2]) return true;
        if(boards[0][2]==c && boards[0][2]==boards[1][1] && boards[0][2]==boards[2][0]) return true;
        
        return false;
    }
}