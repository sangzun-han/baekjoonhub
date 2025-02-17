import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire: wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        for(int[] wire: wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
            
            int network1 = dfs(graph, n, v1, new boolean[n+1]);
            int network2 = n - network1;
            
            answer = Math.min(Math.abs(network1 - network2), answer);
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return answer;
    }
    
    public int dfs(List<List<Integer>> graph, int n, int startNode, boolean[] visited) {
        visited[startNode] = true;
        int count = 1;
        
        for(int neighbor: graph.get(startNode)) {
            if(!visited[neighbor]) {
                count += dfs(graph, n, neighbor, visited);
            }
        }
        
        return count;
    }
}