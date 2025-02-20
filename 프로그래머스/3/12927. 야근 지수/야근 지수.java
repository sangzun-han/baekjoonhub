import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        
        for(int i=0; i<works.length; i++) {
            pq.offer(works[i]);
        }
        
        while(n-- != 0) {
            int work = pq.poll() - 1;
            pq.offer(work);
        }
        
        while(!pq.isEmpty()) {
            int num = pq.poll();
            if(num<0) break;
            
            answer += num * num;
        }
    
        return answer;
    }
}