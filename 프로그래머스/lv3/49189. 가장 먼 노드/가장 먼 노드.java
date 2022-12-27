import java.io.*;
import java.util.*;

class Solution {
    static boolean list[][];
    static boolean visited[];
    static int ans = 0;
    static int N;
    public int solution(int n, int[][] edge) {
        visited = new boolean[n+1];
        list = new boolean[n+1][n+1];
        N = n;
        for(int i=0; i<edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            list[x][y] = true;
            list[y][x] = true;
        }
        
        bfs(1);
        
        return ans;
    }
    
    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            for(int i=0; i<qSize; i++) {
                int n = queue.poll();
                
                for(int j=1; j<=N; j++) {
                    if(list[n][j] && !visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
        ans = qSize;
        }
    }
}