import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int to;
    int cost;
    
    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
    
    public int compareTo(Node node) {
        return this.cost - node.cost;
    }
}

public class Main {
    static int N,M;
    static List<Node>[] graph;
    static int[] d;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        
        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }
        
        d = new int[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;
        
        dijkstra(1);
        System.out.println(d[N]);
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.to;
            
            if(current.cost > d[now]) continue;
            
            for(Node next: graph[now]) {
                if(d[next.to] > d[now] + next.cost) {
                    d[next.to] = d[now] + next.cost;
                    pq.offer(new Node(next.to, d[next.to]));
                }
            }
        }
    }
}
