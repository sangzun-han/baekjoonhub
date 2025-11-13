import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] color;
    static int V,E;
    
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int K = Integer.parseInt(br.readLine());
        
        while(K-->0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList[V+1];
            color = new int[V+1];
            
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
            
            boolean isParticle = true;
            
            for(int i=1; i<=V; i++) {
                if(color[i] == 0) {
                    if(!dfs(i,1)) {
                        isParticle = false;
                        break;
                    }
                }
            }
            sb.append(isParticle ? "YES\n" : "NO\n");
        }
        System.out.println(sb.toString());
    }
    
    public static boolean dfs(int node, int c) {
        color[node] = c;
        
        for(int next: graph[node]) {
            if(color[next]==0) {
                if(!dfs(next, -c)) return false;
            } else if(color[next] == c) {
                return false;
            }
        }
        
        return true;
    }
}
