import java.io.*;
import java.util.*;

class Edge {
    int to;
    int weight;
    
    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static int N,Q;
    static boolean[] visited;
    
    static List<List<Edge>> graph;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            graph.get(p).add(new Edge(q,r));
            graph.get(q).add(new Edge(p,r));    
        }
        
        
        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];
            System.out.println(dfs(k,r));
        }
        
    }
    
    public static int dfs(int k, int r) {
        visited[r] = true;
        int count = 0;
        
        for(Edge edge: graph.get(r)) {
            if(!visited[edge.to] && edge.weight >= k) {
                count++;
                count += dfs(k,edge.to);
            }
        }
        
        return count;
    }
    
}
