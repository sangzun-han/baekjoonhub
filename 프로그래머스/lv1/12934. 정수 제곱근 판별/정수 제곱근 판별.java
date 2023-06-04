import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = -1;
        int size = (int)Math.sqrt(n);
        for(long i=1; i<=size; i++) {
            if(i*i==n) {
                answer = i;
                break;
            }
        }
        
        if(answer == -1) {
            return answer;
        } else {
            return (answer+1)*(answer+1);
        }
        
    }
}