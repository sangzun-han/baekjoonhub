class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int rows = land.length;

        for(int i=1; i<rows; i++) {
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][1], land[i-1][0]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][0]);
        }
        int a = Math.max(land[rows-1][0], land[rows-1][1]);
        int b = Math.max(land[rows-1][2], land[rows-1][3]);
        
        answer = Math.max(a,b);

        return answer;
    }
}