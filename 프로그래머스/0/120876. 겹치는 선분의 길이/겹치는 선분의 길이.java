class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] lineCheck = new int[201];
        
        for(int i=0; i<lines.length; i++) {
            int start = lines[i][0] +100;
            int end = lines[i][1] + 100;
            
            for(int j=start; j<end; j++) {
                lineCheck[j]++;
            }
        }
        
        for(int i=0; i<201; i++) {
            if(lineCheck[i] >= 2) answer++;
        }
        return answer;
    }
}