import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
        
        for(int i=0; i<speeds.length; i++) {
            int remain = 100 - progresses[i];
            int day = (int)Math.ceil((double)remain/speeds[i]);
            list.add(day);
        }
        
        int current = list.get(0);
        int count = 1;
        for(int i=1; i<list.size(); i++) {
    
            if(current >= list.get(i)) {
                count++;
            } else {
                answerList.add(count);
                count = 1;
                current = list.get(i);
            }
        }
        answerList.add(count);
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}


