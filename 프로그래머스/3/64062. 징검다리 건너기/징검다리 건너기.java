class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200_000_000;
        
        while(left <= right) {
            int mid = (left + right) / 2; 
            if(isCross(mid, k, stones)) {
                answer = mid;
                left = mid + 1;   
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean isCross(int mid, int k, int[] stones) {
        int crossPeople = 0;
        
        for(int stone: stones) {
            if(stone - mid < 0) {
                crossPeople++;
                if(crossPeople == k) return false;
            } else {
                crossPeople = 0;
            }
        }
        
        return true; // mid만큼은 건널 수 있음
        
    }
}