import java.util.*;

// 우상, 우, 우하, 하 ,좌하, 좌, 좌상, 상
class Solution {
    static int[] dr = {-1, 0, 1, 2, 1, 0, -1, 2};
    static int[] dc = {1, 2, 1, 0, -1, -2, -1, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<places.length; i++) {
            char[][] room = new char[5][5];

            for(int j=0; j<places[0].length; j++) {
                room[j] = places[i][j].toCharArray();
            }
            
            if(check(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        
        return answer;
    }
    
    public boolean check(char[][] room) {
        for(int i=0; i<room.length; i++) {
            for(int j=0; j<room[i].length; j++) {
                if(room[i][j]=='P') {
                
                    if(!getDistance(room, i,j)) return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean getDistance(char[][] room, int r, int c) {
        int[] ddr = {-1,0,1,0};
        int[] ddc = {0,1,0,-1};
        
        for(int d=0; d<4; d++) {
            int nr = r + ddr[d];
            int nc = c + ddc[d];
            
            if(nr>=0 && nr<5 && nc>=0 && nc<5) {
                if(room[nr][nc]=='P') return false;
            }
        }
        
        for(int d=0; d<8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr>=0 && nr<5 && nc>=0 && nc<5) {
                if(room[nr][nc]=='P') {
                    
                    if(d%2==0) {
                        int tempR = nr - dr[d]/2;
                        int tempC = nc - dc[d]/2;
                        if(room[r][tempC] !='X' || room[tempR][c] != 'X') return false;
                    }
                    else {
                        int tempR = nr - dr[d]/2;
                        int tempC = nc - dc[d]/2;
                        if(room[tempR][tempC] != 'X' ) return false;
                    }
                }
            }
        }
                       
        return true;
    }
}