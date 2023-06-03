import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(true) {
            int m = n%10;
            n = n/10;
            answer+=m;
            if(n==0) break;
        }
        
        
        return answer;
    }
}