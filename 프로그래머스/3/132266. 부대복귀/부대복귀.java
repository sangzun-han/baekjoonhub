import java.util.*;

class Edge {
    int end;
    int cost;
    
    Edge(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Edge>> graph = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.end - b.end);
        
        int[] d = new int[n+1];
        Arrays.fill(d, -1);
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] road: roads) {
            int start = road[0];
            int end = road[1];
            
            graph.get(start).add(new Edge(end, 1));
            graph.get(end).add(new Edge(start, 1));
        }
        
        pq.offer(new Edge(destination,1));
        d[destination] = 0;
        
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            
            for(Edge next: graph.get(edge.end)) {
                if(d[next.end]==-1 || d[next.end] > d[edge.end] + next.cost) {
                    d[next.end] = d[edge.end] + next.cost;
                    pq.offer(new Edge(next.end, d[next.end]));
                }
            }
        }
        
        int[] answer = new int[sources.length];
        
        for(int i=0; i<sources.length; i++) {
            answer[i] = d[sources[i]];
        }
        return answer;
    }
}