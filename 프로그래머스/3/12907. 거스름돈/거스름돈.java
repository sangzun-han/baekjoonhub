class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] d = new int[n+1];
        d[0] = 1;
        
        for(int coin: money) {
            for(int i=coin; i<=n; i++) {
                d[i] = (d[i] + d[i-coin])%1_000_000_007;
            }
        }
        return d[n];
    }
}