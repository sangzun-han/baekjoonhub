import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long dRemain = 0;
        long pRemain = 0;
        
        for(int i=n-1; i>=0; i--) {
            
            dRemain += deliveries[i];
            pRemain += pickups[i];
            
            if(dRemain <= 0 && pRemain <=0) continue;
            
            int repeat = Math.max(
                (int) Math.ceil((double) dRemain / cap),
                (int) Math.ceil((double) pRemain / cap)
            );
            
            answer += (i+1) * 2 * repeat;
            
            dRemain -= cap * repeat;
            pRemain -= cap * repeat;
            
        }
        return answer;
    }
}