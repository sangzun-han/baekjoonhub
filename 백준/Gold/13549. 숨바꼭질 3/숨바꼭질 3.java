import java.io.*;
import java.util.*;

class Point {
    int current;
    int time;
    
    Point(int current, int time) {
        this.current = current;
        this.time = time;
    }
}

public class Main {
    static int SIZE = 200001;
    
    public static void main(String[] args) throws Exception{
        Queue<Point> queue = new ArrayDeque<>();
        
        int[] dist = new int[SIZE];
        boolean[] visited = new boolean[SIZE];
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        dist[N] = 0;
        visited[N] = true;
        queue.offer(new Point(N,0));
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int now = p.current;

            if(now * 2 < SIZE && !visited[now*2]) {
                queue.offer(new Point(now*2, p.time));
                visited[now*2] = true;
                dist[now*2] = dist[now];
            }
            
            if(now - 1 >= 0 && !visited[now-1]) {
                queue.offer(new Point(now-1, p.time+1));
                visited[now-1] = true;
                dist[now-1] = dist[now] + 1;
            }
            
            if(now + 1 < SIZE && !visited[now+1]) {
                queue.offer(new Point(now+1, p.time+1));
                visited[now+1] = true;
                dist[now+1] = dist[now] + 1;
            }
        }
        
        System.out.println(dist[K]);
    }
}
