import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int end,weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }
    static int V,E,K;
    static boolean[] visited;
    static int[] ans;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        K = Integer.parseInt(br.readLine()); //  시작 정점 번호

        visited = new boolean[V+1];
        ans = new int[V+1];
        list = new ArrayList[V+1];

        for(int i=1; i<=V; i++) {
            list[i] = new ArrayList<>();
            ans[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v,w));
        }

        dijkstra();

        for(int i=1; i<=V; i++) {
            if(ans[i]== Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(ans[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K,0));
        ans[K] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(!visited[now.end]) {
                visited[now.end] = true;
            }

            for(int i=0; i<list[now.end].size(); i++) {
                Node next = list[now.end].get(i);

                if(!visited[next.end] && now.weight + next.weight < ans[next.end]) {
                    ans[next.end] = now.weight + next.weight;
                    pq.offer(new Node(next.end, ans[next.end]));
                }
            }
        }
    }
}
