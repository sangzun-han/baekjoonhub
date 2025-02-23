import java.util.*;

class Edge {
    int node;
    int cost;
    
    Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] dp = new int[n];
        boolean[] visited = new boolean[n];
        
        List<List<Edge>> graph = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] cost: costs) {
            int start = cost[0];
            int end = cost[1];
            int price = cost[2];
            graph.get(start).add(new Edge(end, price));
            graph.get(end).add(new Edge(start,price));
        }
        
        dp[0] = 0;
        pq.offer(new Edge(0,0));
        
        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            
            if(visited[current.node]) continue; 
            visited[current.node] = true;
            
            for (Edge edge : graph.get(current.node)) {
                if (!visited[edge.node] && dp[edge.node] > edge.cost) {
                    dp[edge.node] = edge.cost;
                    pq.offer(new Edge(edge.node, dp[edge.node]));
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            answer += (dp[i]);
        }
        
        return answer;
    }
}