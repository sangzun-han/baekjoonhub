import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        
        System.out.println(dfs(s, t));
    }
    
    public static int dfs(String target, String cur) {
        if (target.length() == cur.length()) {
            return target.equals(cur) ? 1 : 0;
        }

        if (cur.charAt(cur.length() - 1) == 'A') {
            String next = cur.substring(0, cur.length() - 1);
            if (dfs(target, next) == 1) return 1;
        }

        if (cur.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(cur.substring(1));
            if (dfs(target, sb.reverse().toString()) == 1) return 1;
        }

        return 0;
    }
}




