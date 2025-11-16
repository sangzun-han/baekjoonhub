import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] 직원 = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();
        
        for(int i=1; i<=n; i++) {
            int 상사 = Integer.parseInt(st.nextToken());
            if(상사==-1) continue;
            graph[상사].add(i);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            직원[num] += w;
            
            
        }
        queue.offer(1);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int next: graph[now]) {
                직원[next] += 직원[now];
                queue.offer(next);
            }
        }
            
        for(int i=1; i<=n; i++) {
            System.out.print(직원[i]+" ");
        }
    }
}
