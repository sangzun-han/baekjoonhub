import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=size-1; i>=0; i--) {
            while(!stack.isEmpty() && numbers[i] >= stack.peek()) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                answer[i] = -1; 
                stack.push(numbers[i]);
            } else {
                answer[i] = stack.peek();
                stack.push(numbers[i]);
            }
        }        
        return answer;
    }
}


   

