import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static int ans[];
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        ans = new int[N+1];
        tree = new ArrayList[N+1];

        for(int i=0; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }
        dfs(1);
        for(int i=2; i<=N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int num) {
        visited[num] = true;
        for(int n: tree[num]) {
            if(!visited[n]) {
                ans[n] = num;
                dfs(n);
            }
        }
    }
}