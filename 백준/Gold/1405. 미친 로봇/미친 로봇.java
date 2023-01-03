import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static double[] per = new double[4];
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static double ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0; i<4; i++) {
            per[i] = Double.parseDouble(st.nextToken())/100;
        }

        visited = new boolean[30][30];
        visited[15][15] = true;
        dfs(15,15,0,1.0);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int cnt, double percent) {
        if(cnt==N) {
            ans += percent;
            return;
        }

        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!visited[nx][ny] && per[d]>0) {
                visited[nx][ny] = true;
                dfs(nx,ny,cnt+1,percent*per[d]);
                visited[nx][ny] = false;
            }
        }
    }
}