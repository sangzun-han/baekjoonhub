import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] workTimes = new int[N+1];
            st = new StringTokenizer(br.readLine());
            
            for(int i=1; i<=N; i++) {
                workTimes[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] indegree = new int[N+1];
            List<Integer>[] graph = new ArrayList[N+1];
            Queue<Integer> queue = new ArrayDeque<>();
            
            for(int i=1; i<=N; i++) {
                graph[i] = new ArrayList<>();
            }
            
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                indegree[Y]++;
                graph[X].add(Y);
            }
            
            int W = Integer.parseInt(br.readLine());
            
            int[] d = new int[N+1];
            
            for(int i=1; i<=N; i++) {
                if(indegree[i]==0) {
                    queue.offer(i);
                    d[i] = workTimes[i];
                }
            }
         
            while(!queue.isEmpty()) {
                int now = queue.poll();
                
                for(int next: graph[now]) {
                    indegree[next]--;
                    d[next] = Math.max(d[next], d[now] + workTimes[next]);
                    
                    if(indegree[next]==0) {
                        queue.offer(next);
                    }
                }
            }
            
            System.out.println(d[W]);
        }
    }
}
