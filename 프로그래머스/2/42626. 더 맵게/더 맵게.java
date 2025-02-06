import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        while(!pq.isEmpty() && pq.size() >= 2) {
            if(pq.peek() >= K) {
                return answer;
            } else {
                int scoville1 = pq.poll();
                int scoville2 = pq.poll();
                pq.offer(scoville1 + (scoville2 * 2));
                answer++;
            }
        }
        
        if(pq.size()==1 && pq.peek() >= K) return answer;
        else return -1;
     
    }
}