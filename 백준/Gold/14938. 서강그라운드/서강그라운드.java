import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int to, dist;
    
    Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}

public class Main {
    static int n,m,r;
    static int[] items;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        
        items = new int[n+1];
    
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        
        graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();
        
        for(int i=1; i<=r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,l));
            graph[b].add(new Node(a,l));
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++) {
            
            int[] dist = dijkstra(i);
            int sum = 0;
            
            for(int j=1; j<=n; j++) {
                if(dist[j] <= m) sum += items[j];
            }
            
            answer = Math.max(answer, sum);
        }
        
        System.out.println(answer);
    }
    
    
    public static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to;
            int cost = cur.dist;
            
            if(cost > dist[now]) continue;
            
            for(Node next: graph[now]) {
                int nextDist = cost + next.dist;
                if(nextDist < dist[next.to]) {
                    dist[next.to] = nextDist;
                    pq.offer(new Node(next.to, nextDist));    
                }
            }
        }
        
        return dist;
    }
    
    
}
