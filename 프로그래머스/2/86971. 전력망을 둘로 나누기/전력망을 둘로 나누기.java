import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire: wires) {
            int from = wire[0];
            int to = wire[1];
            
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        for(int[] wire: wires) {
            int from = wire[0];
            int to = wire[1];
            
            graph.get(from).remove(Integer.valueOf(to));
            graph.get(to).remove(Integer.valueOf(from));
            
            int network1 = bfs(graph, n, from);
            int network2 = n - network1;
            answer = Math.min(Math.abs(network1 - network2), answer);
            
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        return answer;
    }
    
    public int bfs(List<List<Integer>> graph,int n, int startNode) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode);
        visited[startNode] = true;
        int count = 1;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int adjust: graph.get(node)) {
                if(!visited[adjust]) {
                    visited[adjust] = true;
                    queue.offer(adjust);
                    count++;
                }
            }
        }
        
        return count;
    }
}