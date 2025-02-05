import java.util.*;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static char[][] boards;
    static List<Point> list = new ArrayList<>();
    static int N;
    static int M;
    
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        N = n;
        M = m;
        
        boards = new char[m][n];
        
        for(int i=0; i<m; i++) {
            boards[i] = board[i].toCharArray();
        }
        
        while(true) {
            findBlock();
            int count = breakBlock();
            if(count==0) return answer;
            answer += count;
            downBlock();    
        }
        
    }
    
    public int findBlock() {
        for(int i=0; i<M-1; i++) {
            for(int j=0; j<N-1; j++) {
                if(boards[i][j]==boards[i+1][j] && boards[i][j]==boards[i+1][j+1] && boards[i][j]==boards[i][j+1]) {
                    list.add(new Point(i,j));
                }
            }
        }
        return list.size();
    }
    
    public int breakBlock() {
        int count = 0;
        for(Point p: list) {
            int x = p.x;
            int y = p.y;
        
            if(boards[x][y] != '.') count++;
            boards[x][y] = '.';
            if(boards[x+1][y] !='.') count++;
            boards[x+1][y] ='.';
            if(boards[x][y+1] != '.') count++;
            boards[x][y+1] = '.';
            if(boards[x+1][y+1] != '.') count++;
            boards[x+1][y+1] ='.';
        }
        list.clear();    
        return count;    
    }
    
    public void downBlock() {
        for(int i=M-2; i>=0; i--) {
            for(int j=0; j<N; j++) {
                if(boards[i][j] != '.') {
                    int down = i;
                    while(down + 1 < M && boards[down+1][j] == '.') {
                        down++;
                    }
                    
                    if(down != i) {
                        boards[down][j] = boards[i][j];
                        boards[i][j] = '.';
                    }
                 }
            }
        }
    }
}