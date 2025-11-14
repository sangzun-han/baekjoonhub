import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static Queue<Integer> queue = new ArrayDeque<>();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        
        N = Integer.parseInt(br.readLine());
        int[] works = new int[N+1];
        int[] indegree = new int[N+1];
        int[] dp = new int[N+1];
        graph = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            works[i] = Integer.parseInt(st.nextToken());
            int preCount = Integer.parseInt(st.nextToken());
            indegree[i] = preCount;
            
            for(int j=0; j<preCount; j++) {
                int preWork = Integer.parseInt(st.nextToken());
                graph[preWork].add(i);
                
            }
        }
        
        for(int i=1; i<=N; i++) {
            if(indegree[i]==0) {
                queue.offer(i);   
                dp[i] = works[i];
            }
        }
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
                        
            for(int next: graph[now]) {
                indegree[next]--;
                dp[next] = Math.max(dp[next], dp[now] + works[next]);
                
                if(indegree[next]==0) {
                    queue.offer(next);
                }
            }
        }
        
        for(int i=1; i<=N; i++) {
            answer = Math.max(dp[i], answer);
        }
        
        System.out.println(answer);
        
    }
}
