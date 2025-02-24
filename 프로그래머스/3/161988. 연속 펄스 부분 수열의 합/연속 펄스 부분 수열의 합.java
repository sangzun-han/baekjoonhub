class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int[] pearls1 = new int[sequence.length];
        int[] pearls2 = new int[sequence.length];
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        
        for(int i=0; i<sequence.length; i++) {
            if(i%2==0) {
                pearls1[i] = sequence[i] * -1;
            } else {
                pearls1[i] = sequence[i];
            }
             if(i%2==1) {
                pearls2[i] = sequence[i] * -1;
            } else {
                pearls2[i] = sequence[i];
            }
        }
        
        dp1[0] = pearls1[0];
        dp2[0] = pearls2[0];
        
        for(int i=1; i<sequence.length; i++) {
            dp1[i] = Math.max(dp1[i-1] + pearls1[i], pearls1[i]);
            dp2[i] = Math.max(dp2[i-1] + pearls2[i], pearls2[i]);
        }
        
        for(int i=0; i<sequence.length; i++) {
            answer = Math.max(answer, dp1[i]);
            answer = Math.max(answer, dp2[i]);
        }
        
        return answer;
    }
}