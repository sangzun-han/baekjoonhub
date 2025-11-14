import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static List<Integer>[] graph;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int[] indegree = new int[N+1];
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            indegree[B]++;
        }
        
        for(int i=1; i<=N; i++) {
            if(indegree[i]==0) queue.offer(i);
        }
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            
            for(int next: graph[node]) {
                indegree[next]--;
                if(indegree[next]==0) queue.offer(next);
            }
        }
        System.out.println(sb);
    }   
}
