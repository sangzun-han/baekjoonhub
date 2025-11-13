import java.io.*;
import java.util.*;

class Node {
    int node;
    int weight;
    
    Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class Main {
    static int V;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int maxDist;
    static int farNode;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        
        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            
            while(true) {
                int v = Integer.parseInt(st.nextToken());
                if(v==-1) break;
                int w = Integer.parseInt(st.nextToken());
                graph[u].add(new Node(v,w));
            }
        }
        
        visited = new boolean[V+1];
        maxDist = 0;
        dfs(1,0);
        
        visited = new boolean[V+1];
        maxDist = 0;
        dfs(farNode, 0);
        System.out.println(maxDist);
    }
    
    public static void dfs(int node, int dist) {
        visited[node] = true;
        
        if(dist > maxDist) {
            maxDist = dist;
            farNode = node;
        }
        
        for(Node next: graph[node]) {
            if(!visited[next.node]) {
                dfs(next.node, dist + next.weight);
            }
        }
    }
}
