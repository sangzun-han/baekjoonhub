import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=1; i<food.length; i++) {
            if(food[i]/2==0) continue;
            if(food[i]/2==0) {
                for(int j=0; j<=food[i]/2; j++) {
                    stack.push(i);
                    queue.offer(i);
                }
            } else {

                for(int j=0; j<=food[i]/2-1; j++) {
                    stack.push(i);
                    queue.offer(i);
                }
            }
        }
        
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        sb.append(0);
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        answer = sb.toString();
        return answer;
    }
}