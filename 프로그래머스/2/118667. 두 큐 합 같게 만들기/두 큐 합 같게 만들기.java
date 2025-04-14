import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        long sum1 = 0;
        long sum2 = 0;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int i=0; i<queue1.length; i++) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);
        }
        
        for(int i=0; i<queue2.length; i++) {
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }
        
        
        int count = 0;
        int maxCount = queue1.length * 5;
        
        if((sum1+sum2)%2!=0) return -1;
        
        long target = (sum1 + sum2) / 2;
        
        while(count <= maxCount) {
            if(target==sum1 && target==sum2) return count;
            
            if(target < sum1) {
                int num = q1.poll();
                sum1 -= num;
                q2.offer(num);
                count++;
                sum2 += num;
            } else {
                int num = q2.poll();
                sum2 -= num;
                q1.offer(num);
                count++;
                sum1 += num;
            }  
        }
        
        return -1;
    }
}

