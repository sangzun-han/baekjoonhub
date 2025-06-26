import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String s = br.readLine();
            if(s.equals("end")) break;
            char[][] tic = new char[3][3];
            boolean isEmpty = false;
            int xCount = 0;
            int oCount = 0;
            
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                tic[i/3][i%3] = c;
                
                if(c=='.') isEmpty = true;
                if(c=='X') xCount++;
                if(c=='O') oCount++;
            }
            
            if(!isEmpty) {
                if(xCount-1 != oCount) {
                    sb.append("invalid").append("\n");
                    continue;
                }
                
                if(isFinishOfAlpha(tic, 'X') && isFinishOfAlpha(tic, 'O')) {
                    sb.append("invalid").append("\n");
                    continue;
                }
                
                
                if(isFinishOfAlpha(tic, 'O')) {
                    sb.append("invalid").append("\n");
                    continue;
                }
            }
            
    
            if(isEmpty) {
                if (!(xCount == oCount || xCount == oCount + 1)) {
                    sb.append("invalid").append("\n");
                    continue;
                }
                 
                if(isFinishOfAlpha(tic, 'X') && isFinishOfAlpha(tic, 'O')) {
                    sb.append("invalid").append("\n");
                    continue;
                }
                
                if (isFinishOfAlpha(tic, 'X') && xCount != oCount + 1) {
                    sb.append("invalid").append("\n");
                    continue;
                }

                if (isFinishOfAlpha(tic, 'O') && xCount != oCount) {
                    sb.append("invalid").append("\n");
                    continue;
                }
                
                if (!isFinishOfAlpha(tic, 'X') && !isFinishOfAlpha(tic, 'O')) {
                    sb.append("invalid").append("\n");
                    continue;
                }
            }
            sb.append("valid").append("\n");
            
        }
        System.out.println(sb.toString().trim());
    
    }
    
    public static boolean isFinishOfAlpha(char[][] tic, char alpha) {
        if(tic[0][0]==alpha) {
            if((tic[0][0] == tic[0][1]) && (tic[0][0] == tic[0][2])) return true;
            if((tic[0][0] == tic[1][0]) && (tic[0][0] == tic[2][0])) return true;
            if((tic[0][0] == tic[1][1]) && (tic[0][0] == tic[2][2])) return true;
        }
        
        if (tic[1][0] == alpha) {
            if (tic[1][0] == tic[1][1] && tic[1][1] == tic[1][2]) return true;
        }

        if (tic[2][0] == alpha) {
            if (tic[2][0] == tic[2][1] && tic[2][1] == tic[2][2]) return true;
            if (tic[2][0] == tic[1][1] && tic[1][1] == tic[0][2]) return true;
        }

        if (tic[2][1] == alpha) {
            if (tic[2][1] == tic[1][1] && tic[1][1] == tic[0][1]) return true;
        }

        if (tic[2][2] == alpha) {
            if (tic[2][2] == tic[1][2] && tic[1][2] == tic[0][2]) return true;
        }
                
        return false;
    }
}


// 1.빈칸이 없다
// X의개수 - 1 != O의 개수 ->invalid
// 모두 3칸을 이었다 -> invalid

// 2. 빈칸이 있다.
// X의 개수 != O의 개수 && X의 개수-1 != O의 개수 invalud
// 모두 3칸을 이었다 -> invalid
