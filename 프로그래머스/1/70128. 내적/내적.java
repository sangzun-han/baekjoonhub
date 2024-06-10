class Solution {
    public int solution(int[] a, int[] b) {
        int n = a.length;
        int answer = 0;
        for(int i=0; i<n; i++) {
            answer += a[i]*b[i];
        }
       
        return answer;
    }
}