class Solution {

    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = Integer.MAX_VALUE;

        while(left <= right) {
            int level = (left + right) / 2;
            long totalTime = puzzle_game(diffs, times, level);
        
            if(totalTime > limit){
                left = level + 1;
            }
            else {
                answer = level;
                right = level - 1;
            }
        }
        
    
        
        return answer;
    }
    
    public long puzzle_game(int[] diffs, int[] times, int level) {
        long totalTime = 0;
        for(int i=0; i<diffs.length; i++) {
            int diff = diffs[i];
            
            if(diff <= level) {
                totalTime += times[i];
            } else {
                int count = (diff - level);
                totalTime += (times[i-1] + times[i]) * count + times[i];
            }
        }
        
        return totalTime;
    }
}