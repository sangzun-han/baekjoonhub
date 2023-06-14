class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] d = new int[n+1];
        
        d[0] = 0;
        d[1] = 1;
        
        for(int i=2; i<=n; i++) {
            d[i] = (d[i-2] + d[i-1])%1234567;
        }
        
        answer=d[n];
        
        return answer;
    }
    
   
}