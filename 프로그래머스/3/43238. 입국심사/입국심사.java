class Solution {
    public long solution(int n, int[] times) {
        int maxTime = getMaxTime(times);
        long right = (long) n * maxTime;
        long left = 1;
        long answer = 0;
        
        while(left <= right) {
            long mid = (left+right) / 2;
            long people = 0;
            
            for(int i=0; i<times.length; i++) {
                people += mid / times[i];
            }
            
            if(people >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    
    public int getMaxTime(int[] times) {
        int max = 0;
        
        for(int i=0; i<times.length; i++) {
            max = Math.max(max, times[i]);
        }
        return max;
    }
}