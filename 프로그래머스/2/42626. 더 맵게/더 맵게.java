import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            pq.offer((long)scoville[i]);
        }
        
        while(!pq.isEmpty() && pq.size() != 1) {
            long food1 = pq.poll();
            if(food1 >= K) break;
            long food2 = pq.poll() * 2;
            pq.offer(food1+food2);
            count++;
        }
        
        if(pq.size() == 1) {
            if(pq.peek() < K) {
                count = -1;
            }
        }
        
        if(pq.isEmpty()) {
            count = -1;
        }
        int answer = count;
        return answer;
    }
}