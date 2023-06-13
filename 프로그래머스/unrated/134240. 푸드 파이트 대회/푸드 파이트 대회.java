import java.util.*;

class Solution {
    public String solution(int[] food) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
            for(int j=0; j<food[i]/2; j++) {
                    stack.push(i);
                    queue.offer(i);        
            }

        }
        
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        
        sb.append(0);
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        String answer = sb.toString();
        return answer;
    }
}