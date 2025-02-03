import java.util.*;

class Edge {
    int end;
    int time;
    
    Edge(int end, int time) {
        this.end = end;
        this.time = time;
    }
}

class Solution {
    List<List<Edge>> graph = new ArrayList<>();

    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int time = road[i][2];
            
            graph.get(start).add(new Edge(end, time));
            graph.get(end).add(new Edge(start, time));
        }
        
        answer = dijkstra(N,K);
        return answer;
    }
    
    public int dijkstra(int N, int K) {
        int count = 0;
        int[] d = new int[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2) -> (e1.time - e2.time));
        pq.offer(new Edge(1,0));
        
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            
            int nowNode = e.end;
            int nowTime = e.time;
            
            for(Edge next: graph.get(nowNode)) {
                int time = nowTime + next.time;
                if(time < d[next.end]) {
                    d[next.end] = time;
                    pq.offer(new Edge(next.end, time));
                }
            }
            
        }
        
        for(int i=1; i<=N; i++) {
            if(d[i]<=K) count++;
        }
        
        return count;
        
    }
}