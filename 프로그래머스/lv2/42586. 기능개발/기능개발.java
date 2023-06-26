import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++) {
            int day = 0;
            if((100 - progresses[i]) % speeds[i] == 0) {
                day = (100-progresses[i]) / speeds[i];
            } else {
                day = ((100-progresses[i]) / speeds[i]+1);
            }
            
            queue.offer(day);
        }
        
        while(!queue.isEmpty()) {
            int remain = queue.peek();
            
            int count = 0;
            while(!queue.isEmpty() && remain >= queue.peek()) {
                queue.poll();
                count++;
            }
            count = count==0 ? 1 : count;
            list.add(count);
        }
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}