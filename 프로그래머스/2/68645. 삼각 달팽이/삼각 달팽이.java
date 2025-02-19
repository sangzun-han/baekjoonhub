class Solution {
    // 아래, 오른쪽, 대각선위
    static int[] dr = {1, 0, -1};
    static int[] dc = {0, 1, -1};
    
    public int[] solution(int n) {
      
        int[][] triangle = new int[n][];
             
        for(int i=0; i<n; i++) {
            triangle[i] = new int[i+1];
        }
        
        int maxNum = n * (n+1) / 2;
        int d = 0;
        int num = 1;
        int r = 0;
        int c = 0;
        
        while(num <= maxNum) {
            triangle[r][c] = num++;
            
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr>=n || nc >= triangle[nr].length || triangle[nr][nc] != 0) {
                d = (d + 1) % 3;
                nr = r + dr[d];
                nc = c + dc[d];
            }
            
            r = nr;
            c = nc;
        }
        int[] answer = new int[maxNum];
        int index = 0;
        
        for(int i=0; i<triangle.length; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                answer[index++] = triangle[i][j];
            }
        }
        return answer;
    }
}