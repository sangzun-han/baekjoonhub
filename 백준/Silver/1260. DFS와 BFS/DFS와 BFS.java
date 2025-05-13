import java.io.*;
import java.util.*;

public class Main {
    static int N,M,V;
    static int[][] dfsGraph;
    static int[][] bfsGraph;
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        dfsGraph = new int[N+1][N+1];
        bfsGraph = new int[N+1][N+1];
        dfsVisited = new boolean[N+1];
        bfsVisited = new boolean[N+1];
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dfsGraph[x][y] = 1;
            dfsGraph[y][x] = 1;
            bfsGraph[x][y] = 1;
            bfsGraph[y][x] = 1;
        }
        
        dfs(V);
        System.out.println();
        bfs(V);
    }
    
    public static void dfs(int v) {
        System.out.print(v+" ");
        dfsVisited[v] = true;
               
        for(int i=1; i<=N; i++) {
            if(!dfsVisited[i] && dfsGraph[v][i]==1) {
                dfs(i);
            }
        }   
    }
    
    public static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(v);
        bfsVisited[v] = true;
        
        while(!queue.isEmpty()) {
            int next = queue.poll();
            System.out.print(next+" ");
            
            for(int i=1; i<=N; i++) {
                if(!bfsVisited[i] && bfsGraph[next][i]==1) {
                    queue.offer(i);
                    bfsVisited[i] = true;
                }
            }
        }
    }
    
   
}

