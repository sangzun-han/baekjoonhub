import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        Arrays.sort(A);
    
        for(int i=0; i<B.length; i++) {
            pq.offer(B[i]);
        }
        
        for(int i=0; i<A.length; i++) {
            int target = A[i];
            while(!pq.isEmpty()) {
                if(target < pq.peek()) {
                    pq.poll();
                    answer++;
                    break;
                } else {
                    pq.poll();
                }
            }
        }
        return answer;
    }
}