import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V+1];
        visited = new boolean[V+1];
        
        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for(int i=1; i<=V; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;               
            }
        }
        
        System.out.println(answer);
    }
    
    public static void dfs(int node) {
        visited[node] = true;
        
        for(int n: graph[node]) {
            if(visited[n]) continue;
            
            visited[n] = true;
            dfs(n);
        }
    }
}
