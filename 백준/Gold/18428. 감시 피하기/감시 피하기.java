import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] board;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static String answer = "NO";
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
            
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }
        

        comb(0);
        System.out.println(answer);
    }
    
    public static void comb(int count) {
        // 장애물 설치 완료.
        if(count==3) {
            if(avoidFromTeacher()) {
                answer = "YES";
            }
            
            return;
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] == 'X') {
                    board[i][j] = 'O';
                    comb(count+1);
                    board[i][j] = 'X';
                }
            }
        }
        
        
        
    }
    
    public static boolean avoidFromTeacher() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j]=='T') {
                    for(int d=0; d<4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                            if (board[nr][nc] == 'O') break;
                            if (board[nr][nc] == 'S') return false; 
                            nr += dr[d];
                            nc += dc[d];
                        }
                    }
                }
            }
        }
        return true;
    }
}

// 장애물 3개를설치한다. 조합.
// 선생님 위치에서 시작 상하좌우 직선으로 탐색, 학생 만난다면 false 하나라도 학생 안만났다면 ok