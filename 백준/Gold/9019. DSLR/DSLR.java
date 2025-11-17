import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 10000;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
    
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            sb.append(bfs(A,B)).append("\n");
        }
        System.out.println(sb);
    }
    
    
    public static String bfs(int start, int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX];
        Queue<String> query = new ArrayDeque<>();
        
        queue.offer(start);
        query.offer("");
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            String c = query.poll();
            
            if(now==target) return c;
            
            int D = now * 2 % MAX;
            
            if(!visited[D]) {
                queue.offer(D);
                visited[D] = true;
                query.offer(c + "D");    
            }
            
            int S = now==0 ? 9999 : now-1;
            if(!visited[S]) {
                queue.offer(S);
                visited[S] = true;
                query.offer(c + "S");    
            }
            
            int L = (now%1000) * 10 + (now/1000);
            
            if(!visited[L]) {
                queue.offer(L);
                visited[L] = true;
                query.offer(c + "L");    
            }
            
            int R = (now % 10) * 1000 + (now/10);
            if(!visited[R]) {
                queue.offer(R);
                visited[R] = true;
                query.offer(c + "R");    
            }
        }
        
        return "";
    }
}
