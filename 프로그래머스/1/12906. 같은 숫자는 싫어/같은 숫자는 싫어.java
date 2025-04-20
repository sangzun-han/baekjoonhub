import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<arr.length; i++) {
            int num = arr[i];
            
            if(!stack.isEmpty()) {
                if(stack.peek() == num)  continue;
                else stack.push(num);
            } else {
                stack.push(num);
            }
        }

        int[] answer = new int[stack.size()];
        int index = stack.size() - 1;
        
        while(!stack.isEmpty()) {
            answer[index--] = stack.pop();
        }
        
        return answer;
    }
}
