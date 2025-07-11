import java.io.*;
import java.util.*;

public class Main {
    static char[][] boards;
    static int R,C;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static Set<Character> alphabet = new HashSet<>();
    static int answer = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        boolean possible = false;
        
        boards = new char[R][C];
        
        for(int i=0; i<R; i++) {
            boards[i] = br.readLine().toCharArray();
        }
        
        for(int d=0; d<4; d++) {
            char current = boards[0][0];
            if(dr[d]>=0 && dr[d]<R && dc[d]>=0 && dc[d]<C) {
                if(current != boards[dr[d]][dc[d]]) {
                    possible = true;
                    break;
                }
            }
        }
        
        if(!possible) {
            System.out.println(1);
            return;
        }
        
        alphabet.add(boards[0][0]);
        backtracking(0,0,0, possible);
        System.out.println(answer+1);
    }
    
    public static void backtracking(int r, int c, int count, boolean possible) {
        if(!possible || (r==R-1 && c==C-1)) {
            answer = Math.max(answer, count);
            return;
        }
        
        boolean isPossible = false;
                
        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr>=0 && nr<R && nc>=0 && nc<C && !alphabet.contains(boards[nr][nc])) {
                isPossible = true;
                alphabet.add(boards[nr][nc]);
                backtracking(nr,nc, count+1, isPossible);
                alphabet.remove(boards[nr][nc]);
                backtracking(nr,nc, count+1, !isPossible);
            }
        }
        
    }
}
