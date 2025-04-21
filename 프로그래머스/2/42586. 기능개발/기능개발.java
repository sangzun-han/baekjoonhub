import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> answerList = new ArrayList<>();
        
        for(int i=0; i<speeds.length; i++) {
            int speed = speeds[i];
            int progress = progresses[i];
            int day = (int)Math.ceil((double)((100 - progress) / (double)speed));
            queue.offer(day);
        }
        
        while(!queue.isEmpty()) {
            int day = queue.poll();
            int count = 1;
            
            while(!queue.isEmpty() && day >= queue.peek()) {
                queue.poll();
                count++;
            }
            answerList.add(count);
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
