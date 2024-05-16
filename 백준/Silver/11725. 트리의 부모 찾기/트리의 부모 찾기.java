import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        ans = new int[N+1];



        for(int i=0; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }


        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);
        for(int i=2; i<=N; i++) {
            System.out.println(ans[i]);
        }
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
