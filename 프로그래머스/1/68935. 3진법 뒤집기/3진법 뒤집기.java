import java.util.*;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        int N = n;
        
        while(N>0) {
            sb.append(N%3);
            N /= 3;
        }
        answer = Integer.parseInt(sb.toString(),3);
        return answer;
    }
}