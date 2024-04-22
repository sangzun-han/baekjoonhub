import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] board = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=0; i<board.length; i++) {
            if(board[i]=='X') {
                count++;
            } else {
                if(count > 0) {
                    while(count>=4) {
                        sb.append("AAAA");
                        count-=4;
                    }
                    if(count==2) {
                        sb.append("BB");
                        count-=2;
                    }
                    if(count!=0) {
                        System.out.println(-1);
                        return;
                    }
                }
                sb.append(".");
            }
        }

        if(count > 0) {
            while(count>=4) {
                sb.append("AAAA");
                count-=4;
            }
            if(count==2) {
                sb.append("BB");
                count-=2;
            }
            if(count!=0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(sb);
    }


}
