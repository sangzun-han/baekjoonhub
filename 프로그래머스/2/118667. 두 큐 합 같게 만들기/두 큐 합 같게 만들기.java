import java.util.*;
class Solution {
    static long queue1Sum = 0;
    static long queue2Sum = 0;
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
    
        for(int i=0; i<queue1.length; i++) {
            queue1Sum += (long) queue1[i];
            q1.offer(queue1[i]);
        }
        
        for(int i=0; i<queue2.length; i++) {
            queue2Sum += (long) queue2[i];
            q2.offer(queue2[i]);
        }
        
        if((queue1Sum + queue2Sum)%2 != 0) return -1;
        
        long find = (queue1Sum + queue2Sum) / 2;
        
        int count = 0;
        int maxCount = queue1.length * 3;
        
        while(!q1.isEmpty() && !q2.isEmpty() && count <= maxCount) {
            if(find == queue1Sum && find == queue2Sum) {
                break;
            }
            if(find < queue1Sum && find > queue2Sum) {
                int q1Num = q1.poll();
                q2.offer(q1Num);
                queue1Sum -= q1Num;
                queue2Sum += q1Num;
                count++;
            }
            if(find < queue2Sum && find > queue1Sum) {
                int q2Num = q2.poll();
                q1.offer(q2Num);
                queue2Sum -= q2Num;
                queue1Sum += q2Num;
                count++;
            }
            
        }
        if(find != queue1Sum && find != queue2Sum) {
                return -1;
        }
        return count;
    }
}
