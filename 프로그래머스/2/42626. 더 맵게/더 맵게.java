import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        
        for(int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int mixCount = 0;
        
        while(!pq.isEmpty() && pq.size() >=2) {
            if(pq.peek() >= K) return mixCount;
            int first = pq.poll();
            int second = pq.poll() * 2;
            int mixScoville = first + second;
            pq.offer(mixScoville);
            mixCount++;
        }
        
        if(pq.size()==1 && pq.peek() >= K) return mixCount;
        else return -1;
    }
}