class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int col = w;
        int row = n/w+1;
        
        int[][] map = new int[row][col];
        int count = 1;
        int r = 0;
        int c = 0;
        for(int i=0; i<row; i++) {
            if(i%2==0) {
              for(int j=0; j<col; j++) {
                if(count > n) break;
                map[i][j] = count++;
                if(map[i][j]==num) {
                    r = i;
                    c = j;
                }
            }  
            } else {
                  for(int j=col-1; j>=0; j--) {
                    if(count > n) break;
                    map[i][j] = count++;
                    if(map[i][j]==num) {
                        r = i;
                        c = j;
                    }
                }  
            }
          
        }
        while(r>=0 && r<row && map[r][c] != 0) {
            answer++;
            r++;
        }
        
        return answer;
    }
}