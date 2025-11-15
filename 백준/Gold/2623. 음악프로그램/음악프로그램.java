import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        graph = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int singer = Integer.parseInt(st.nextToken());
            int[] temp = new int[singer];
            
            for(int j=0; j<singer; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            
            for(int j=0; j<singer-1; j++) {
                graph[temp[j]].add(temp[j+1]);
                indegree[temp[j+1]]++;   
            }
        }
        
        for(int i=1; i<=N; i++) {    
            if(indegree[i]==0) {
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            count++;
            sb.append(now).append("\n");
            
            for(int next: graph[now]) {
                indegree[next]--;
                
                if(indegree[next]==0) queue.offer(next);
            }
        }
        
        if (count != N) {
            System.out.println(0);
        } else {
          System.out.println(sb);      
        }
        
      
    }

}
