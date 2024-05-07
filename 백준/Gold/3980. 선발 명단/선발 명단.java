import java.io.*;
import java.util.*;

public class Main {
    static int c;
    static int[][] s;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        c = Integer.parseInt(br.readLine());

        for(int k=0; k<c; k++) {
            s = new int[11][11];
            visited = new boolean[11];
            ans = -1;
            for(int i=0; i<11; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<11; j++) {
                    s[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0,0);
          sb.append(ans).append("\n");
        }
        System.out.println(sb);



    }

    private static void dfs(int cnt, int sum) {
        if(cnt==11) {
            ans = Math.max(ans, sum);
            return;
        }
        for(int i=0; i<11; i++) {
            if(!visited[i] && s[cnt][i]!=0) {
                visited[i] = true;
                dfs(cnt+1, sum + s[cnt][i]);
                visited[i] = false;
            }
        }
    }
}
