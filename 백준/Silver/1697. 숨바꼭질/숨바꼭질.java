import java.util.*;
import java.io.*;

class Position {
    int position;
    int count;
    
    Position(int position, int count) {
        this.position = position;
        this.count = count;
    }
}

public class Main {
    static int[] dist = {2,1,-1};
    
    public static void main(String[] args) throws Exception{
        Queue<Position> queue = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 동생위치까지만 해보면 최단거리 아닐수도있음, *2 하고 -1로오는게 더 빠른경우 있을수도있음
        boolean[] visited = new boolean[100001];
        // 항상 앞으로 가는거 *2, +1, -1. 순으로 가야 최단거리뜸
        
        queue.offer(new Position(N, 0));
        visited[N] = true;
        int answer = -1;
        
        while(!queue.isEmpty()) {
            Position pos = queue.poll();
            if(pos.position==K) {
                answer = pos.count;
                break;
            }
            for(int d=0; d<3; d++) {
                int next;
                if(d==0) {
                    next = pos.position * dist[d]; 
                } else {
                    next = pos.position + dist[d];
                }
                
                if(next < 0 ||next >= 100001 || visited[next]) continue;
                
                queue.offer(new Position(next, pos.count+1));
                visited[next] = true;
            }
        }
        
        System.out.println(answer);
    }
}

