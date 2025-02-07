import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int e: enemy) {
            pq.offer(e);
            n -= e;
            
            if(n < 0) {
                if(k>0 && !pq.isEmpty()) {                    
                    // 무적권
                    n += pq.poll();
                    k--;
                } else {
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}