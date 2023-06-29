import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
  
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<progresses.length; i++) {
            if((100-progresses[i]) % speeds[i] == 0) {
                queue.offer((100-progresses[i])/speeds[i]);
            } else {
                queue.offer((100-progresses[i])/speeds[i] + 1);
            }
        }
        
        while(!queue.isEmpty()) {
            int count = 1;
            int peek = queue.poll();
            while(!queue.isEmpty() && peek >= queue.peek()) {
                count++;
                queue.poll();
            }
            list.add(count);
        }
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}