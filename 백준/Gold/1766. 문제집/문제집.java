import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer>[] graph = new ArrayList[N+1];
        
        for(int i=1; i<=N ;i++) {
            graph[i] = new ArrayList<>();
        }
        
        int[] indegree = new int[N+1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            graph[A].add(B);
            indegree[B]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=1; i<=N; i++) {
            if(indegree[i]==0) pq.offer(i);
        }
        
        while(!pq.isEmpty()) {
            int now = pq.poll();
            
            sb.append(now).append(" ");
            
            for(int next: graph[now]) {
                indegree[next]--;
                if(indegree[next]==0) {
                    pq.offer(next);
                }
            }
        }
        
        System.out.println(sb);
    }
}