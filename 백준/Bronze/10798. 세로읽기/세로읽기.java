import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        char[][] words = new char[5][15];

        for(int i=0; i<5; i++) {
            String s = br.readLine();
            for(int j=0; j<s.length(); j++) {
                words[i][j] = s.charAt(j);
            }
        }

        int maxLen = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                if (words[i][j] == '\0') break;
                if (j > maxLen) maxLen = j;
            }
        }

        for (int i = 0; i <= maxLen; i++) { // 최대 길이까지 반복
            for (int j = 0; j < 5; j++) {
                if (words[j][i] != '\0') {
                    sb.append(words[j][i]);
                }
            }
        }




        System.out.println(sb);

    }
}

