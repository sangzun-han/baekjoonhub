import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1;
        int right = maxDiffs(diffs);
       
        while(left <= right) {
            int level = (left+right) / 2;
            if(canLimit(diffs, times, limit, level)) {
                right = level - 1;
                answer = level;
            } else {
                left = level + 1;
            }
        }
        return answer;
    }
    
    public int maxDiffs(int[] diffs) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<diffs.length; i++) {
            max = Math.max(max, diffs[i]);
        }
        
        return max;
    }
    
    public boolean canLimit(int[] diffs, int[] times, long limit, int level) {        
        long currentTime = 0;
        for(int i=0; i<diffs.length; i++) {
            int diff = diffs[i];
            int time = times[i];
            
            if(diff <= level) currentTime += time;
            else {
                int count = diff - level;
                currentTime += (time + times[i-1]) * count + time;
            }
        }
        if(limit >= currentTime) return true;
        
        return false;
    }
}