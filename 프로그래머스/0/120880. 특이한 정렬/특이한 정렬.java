import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> {
            int distA = Math.abs(a-n);
            int distB = Math.abs(b-n);
            
            if(distA == distB) {
                return b-a;
            } else {
                return distA-distB;
            }
        });
        
        for(int num: numlist) {
            queue.add(num);
        }
        
        int[] answer = new int[numlist.length];
        
        for(int i=0; i<numlist.length; i++) {
            answer[i] = queue.poll();
        }
                
        return answer;
    }
}