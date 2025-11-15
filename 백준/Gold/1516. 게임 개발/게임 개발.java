import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        int[] times = new int[N+1];
        int[] d = new int[N+1];
        int[] indegree = new int[N+1];
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        List<Integer>[] graph = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            times[i] = u;
            while(true) {
                int v = Integer.parseInt(st.nextToken());
                if(v==-1) break;
                graph[v].add(i);
                indegree[i]++;
            }
        }
        
        for(int i=1; i<=N; i++) {
            if(indegree[i]==0) {
                queue.offer(i);
                d[i] = times[i];
            }
        }
        
        while(!queue.isEmpty()) {
            int now = queue.poll();    
                    
            for(int next: graph[now]) {
                indegree[next]--;
                d[next] = Math.max(d[next], d[now] + times[next]);
                
                if(indegree[next]==0) queue.offer(next);
            }
        }
        
        for(int i=1; i<=N; i++) {
            System.out.println(d[i]);
        }
    }
}
