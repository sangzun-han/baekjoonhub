class Solution {
    public long[] solution(long x, int n) {
        long[] answer = new long[n];
        long X = x;
        for(int i=0; i<n; i++) {
            answer[i]=X;
            X+=x;
        }
        return answer;
    }
}