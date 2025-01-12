class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int x = park.length;
        int y = park[0].length;
        
        for(int i=0; i<mats.length; i++) {
            int mat = mats[i];
            
            for(int j=0; j<x; j++) {
                for(int k=0; k<y; k++) {
                    if(park[j][k].equals("-1")) {
                        answer = Math.max(answer, check(park, j,k, mat));
                    }
                }
            }
        }
        return answer;
    }
    
    private int check(String[][] park, int x, int y, int mat) {
        int n = park.length;
        int m = park[0].length;
        // x,y 시작점
        int count = 0;
        for(int i=x; i<x+mat; i++) {
            for(int j=y; j<y+mat; j++) {
                if(i<n && j<m) {
                    if(!park[i][j].equals("-1")) {
                        return -1;
                    }
                    count++;

                } 
            }
        }
        return (count == mat * mat) ? mat : -1;
 
    }
}