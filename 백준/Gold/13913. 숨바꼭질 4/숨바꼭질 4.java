import java.io.*;
import java.util.*;
public class Main {
    static int N,K;
    static int max = 200001;
    static int[] d = new int[max];
    static int[] from = new int[max];
    static boolean[] visited = new boolean[max];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N);

        System.out.println(d[K]);
        print(N,K);
    }

    private static void print(int n, int k) {
        if(n!=k) {
            print(n, from[k]);
        }
        System.out.print(k+" ");
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[x] = true;
        queue.offer(x);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now*2 <max && !visited[2*now] ) {
                queue.offer(2*now);
                d[2*now] = d[now] + 1;
                from[2*now] = now;
                visited[2*now] = true;
            } if (now-1 >= 0 &&!visited[now-1] ) {
                queue.offer(now-1);
                d[now-1] = d[now] + 1;
                from[now-1] = now;
                visited[now-1] = true;
            } if (now+1 < max && !visited[now+1]) {
                queue.offer(now+1);
                d[now+1] = d[now] + 1;
                from[now+1] = now;
                visited[now+1] = true;
            }
        }
    }
}