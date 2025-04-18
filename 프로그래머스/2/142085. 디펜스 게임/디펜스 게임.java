import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int answer = 0;
        
        for(int i=0; i<enemy.length; i++) {
            pq.offer(enemy[i]);
            n -= enemy[i];
            
            if(n < 0) {
                n += pq.poll();
                k--;
                
                if(k<0) break;
            } 
            
            answer++;
        }
        
        return answer;
    }
}
