import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int[] parentArr;
    static boolean[] visited;
    static int deleted;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        parentArr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int root = -1;

        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            parentArr[i] = p;
            if (p == -1) root = i;
            else graph[p].add(i);
        }

        deleted = Integer.parseInt(br.readLine());


        int p = parentArr[deleted];
        if (p != -1) {
            graph[p].remove(Integer.valueOf(deleted));
        }

        if (deleted == root) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(root));
    }

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        int leafCount = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            int availableChild = 0;

            for (int child : graph[now]) {
                if (child == deleted) continue;
                availableChild++;

                if (!visited[child]) {
                    visited[child] = true;
                    q.offer(child);
                }
            }

            if (availableChild == 0) {
                leafCount++;
            }
        }

        return leafCount;
    }
}