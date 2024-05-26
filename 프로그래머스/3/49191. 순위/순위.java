import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int INF = 99999;
        int[][] graph = new int[n][n];
        
        // 그래프 초기화
        for(int i=0; i<n ;i++) {
            for(int j=0; j<n; j++) {
                if(i==j) graph[i][j] = 0;
                else {
                    graph[i][j] = INF;
                }
            }
        }
        
        // a선수가 b선수를 이긴다.
        for(int[] result: results) {
            int a = result[0] - 1;
            int b = result[1] - 1;
            graph[a][b] = 1; 
        }
        
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++) {
            boolean flag = true;
            for(int j=0; j<n; j++) {
                if(i!=j && graph[i][j] == INF && graph[j][i]==INF) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}