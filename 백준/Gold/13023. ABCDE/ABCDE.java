import java.io.*;
import java.util.*;

public class Main {
    static int V,E;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int answer = 0;
        visited = new boolean[V];
        graph = new ArrayList[V];
        
        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        found = false;
        
        for(int i=0; i<V; i++) {
            visited = new boolean[V];
            dfs(i, 1);
            if(found) break;
        }
        
        System.out.println(found ? 1 : 0);
    }
    
    public static void dfs(int node, int count) {
        if(count==5) {
            found = true;
            return;
        }
        
        visited[node] = true;
        
        for(int n: graph[node]) {
            if(!visited[n]) {
                dfs(n, count+1);
                if(found) return;
            }
        }
        
        visited[node] = false;
    }
    
}
