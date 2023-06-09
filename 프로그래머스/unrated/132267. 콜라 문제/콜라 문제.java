class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int N = n;
        int m = 0;
        
        while(true) {
            m = N/a*b; // m병 받음
            answer +=m;
            N = N%a; // N병남음
            N += m;
            if(N/a==0) break;
        }
        return answer;
    }
}