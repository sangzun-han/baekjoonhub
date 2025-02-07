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
    static int N = 5;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    static int[] dxr = {-1, -1, 1, 1}; 
    static int[] dxc = {-1, 1, -1, 1};

    
    static int[] drr = {-2,0,2,0};
    static int[] dcc = {0,2,0,-2};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[N];
        int index = 0; 
        
        Map<Integer, String[]> boards = new HashMap<>();
        for(int i=0; i<N; i++) {
            boards.put(i+1, places[i]);
        }
        
        
        for(int key: boards.keySet()) {
            String[] board = boards.get(key);
            char[][] map = new char[N][N];
            for(int i=0; i<N; i++) {
                map[i] = board[i].toCharArray();
            }
            
            boolean isSafe = true;
            for(int i=0; i<N; i++) { 
                for(int j=0; j<N; j++) {
                    if(map[i][j]=='P') {
                        if(!checkDistance(map, i,j)) {
                            isSafe = false;
                            break;
                        }
                    }
                }
                if(!isSafe) break;
            }
            
            answer[index++] = isSafe ? 1 : 0;
            
            
        }
        return answer;
    }
        
    public boolean checkDistance(char[][] map, int r, int c) {
        // 상하좌우일때는 P있으면 거리두기 안하고 있다.
        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]=='P') {
                return false;
            }
        }
        
        // 대각선일때는 파티션 확인 해야함
        for(int d=0; d<4; d++) {
            int nr = r + dxr[d];
            int nc = c + dxc[d];
            
            if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]=='P') {
                if(map[nr][c]=='O' || map[r][nc]=='O' || map[nr][c]=='P' || map[r][nc]=='P') return false;    
            }
        }
        
        // 2칸짜리 상하좌우 확인할때도 파티션 확인해야함
        for(int d=0; d<4; d++) {
            int nr = r + drr[d];
            int nc = c + dcc[d];
            
            if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]=='P') {
                
                int mr = r + drr[d] / 2;
                int mc = c + dcc[d] / 2;
                if(mr>=0 && mr<N && mc>=0 && mc<N) {
                    if (map[mr][mc] != 'X') {
                        return false;
                    }
                }       
            }
        }
        
        return true;
    }
}