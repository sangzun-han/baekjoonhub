class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        int N = 120;
        int M = 120;
        int INF = Integer.MAX_VALUE;
        int[][][] d = new int[len+1][N][M];
        // d[i][a][b] : i번째 까지 고려했을 때 A가 남긴흔적이 a, B가 남긴 흔적b 중 A가 남긴 흔적의 최소값
        
        for(int i=0; i<=len; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    d[i][j][k] = INF;
                }
            }
        }
        
        d[0][0][0] = 0;
        
        for(int i=0; i<len; i++) {
            int a = info[i][0];
            int b = info[i][1];
            
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(d[i][j][k]==Integer.MAX_VALUE) continue;
                    // dp배열을 벗어나지 않도록.
                    // A 도둑이 가져가는 경우
                    if(j+a < N) {
                        d[i+1][j+a][k] = Math.min(d[i+1][j+a][k], d[i][j][k] + a);
                    }
                    
                    
                    if(k+b < M) {
                        d[i+1][j][k+b] = Math.min(d[i+1][j][k+b], d[i][j][k]);
                    }
                }
            }
        }
        int answer = INF;
            
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                answer = Math.min(answer, d[len][i][j]);
            }
        }
        
        
        return answer == INF ? -1 : answer;
    }
}