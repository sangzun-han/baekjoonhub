import java.io.*;
import java.util.*;

public class Main {
    static int n,s;
    static int[] nums;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        visited = new boolean[n+1];
        ans = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());

        dfs(s);
        System.out.println(ans);
    }

    private static void dfs(int pos) {

        visited[pos] = true;
        int cnt = 0;

        for(int i=1; i<=n; i++) {
            if(visited[i]) {
                cnt++;
            }
        }

        if(cnt==n) {
            return;
        }

        int moveLeft = pos - nums[pos];
        if (moveLeft >= 1 && !visited[moveLeft]) {
            ans++;
            dfs(moveLeft);
        }

        // 현재 위치에서 오른쪽으로 점프하는 경우
        int moveRight = pos + nums[pos];
        if (moveRight <= n && !visited[moveRight]) {
            ans++;
            dfs(moveRight);
        }
    }
}
