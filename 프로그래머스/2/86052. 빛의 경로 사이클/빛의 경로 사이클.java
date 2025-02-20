import java.util.*;

class Solution {
    static int n,m;
    static int[] dr = {1,0,-1,0}; // 하,우,상,좌
    static int[] dc = {0,1,0,-1};
    
    static int[] left = {1,2,3,0};
    static int[] right = {3,0,1,2};  
    
    static char[][] board;
    static boolean[][][] visited;
    public int[] solution(String[] grid) {
        
        List<Integer> answerList = new ArrayList<>();
        
        n = grid.length;
        m = grid[0].length();
        
        board = new char[n][m];
        visited = new boolean[n][m][4];
        
        for(int i=0; i<n; i++) {
            board[i] = grid[i].toCharArray();
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                for(int d=0; d<4; d++) {
                    if(!visited[i][j][d]) {
                        int len = go(i,j,d);
                        answerList.add(len);
                    }
                }
            }
        }
        Collections.sort(answerList);
        int[] answer = new int[answerList.size()];
        
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    public int go(int r, int c, int dir) {
        int length = 0;
        
        while(!visited[r][c][dir]) {
            visited[r][c][dir] = true;
            length++;
            
            r = (r+dr[dir]+n) % n;
            c = (c+dc[dir]+m) % m;
            
            if(board[r][c]=='L') dir = left[dir];
            else if(board[r][c]=='R') dir = right[dir];     
        }
        
        return length;
    }
    
}