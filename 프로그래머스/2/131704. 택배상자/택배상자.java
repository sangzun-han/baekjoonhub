import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int count = 0;
        for(int i=0; i<order.length; i++) {
            queue.offer(i+1);
        }

        
        while(!queue.isEmpty() || !stack.isEmpty()) {
            
            while(!stack.isEmpty() && stack.peek() == order[index]) {
                count++;
                index++;
                stack.pop();
            }
            
            
            if(!queue.isEmpty()) {
                int box = queue.poll();
                if(box==order[index]) {
                    count++;
                    index++;
                } else {
                    stack.push(box);
                }
            } else {
                break;
            }
        }
        
        
        return count;
    }
}

