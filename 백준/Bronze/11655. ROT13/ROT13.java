import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isUpperCase(c)) {
                char convert = (char) ('A' + (c - 'A' + 13)  % 26);
                sb.append(convert);
            } else if(Character.isLowerCase(c)) {
                char convert = (char) ('a' + (c - 'a' + 13)  % 26);
                sb.append(convert);
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
