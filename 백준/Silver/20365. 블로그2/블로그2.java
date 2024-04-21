import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        char[] solved = br.readLine().toCharArray();
        int changeB = 0;
        int changeR = 0;

        char prevColor = 'a';

        for(int i=0; i<N; i++) {
            if(solved[i] != prevColor) {
                if(solved[i] == 'B') changeB++;
                else changeR++;
                prevColor = solved[i];
            }
        }

        System.out.println(Math.min(changeB, changeR)+1);


    }
}
