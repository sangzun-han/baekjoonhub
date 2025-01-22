class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int n = park.length;
        int m = park[0].length;
        
        for(int mat: mats) {
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                   if(park[i][j].equals("-1")) {
                       int count = calc(i,j,park,mat);
                       if(count == mat*mat) {
                           answer = Math.max(answer, mat);
                       }
                   }
                }
            }
        }
        return answer;
    }
    
    private int calc(int x, int y, String[][] park, int mat) {
        int count = 0;
        int n = park.length;
        int m = park[0].length;
        
        for(int i=x; i<x+mat; i++) {
            for(int j=y; j<y+mat; j++) {
                if(i>=n || j>=m) return -1;
                else if(park[i][j].equals("-1")) count++;
            }
        }
        return count;
    }
}