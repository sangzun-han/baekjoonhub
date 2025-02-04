import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for(char num: number.toCharArray()) {
            
            while(!stack.isEmpty() && k>0 && stack.peek() < num) {
                stack.pop();
                k--;
            }
            
            stack.push(num);
        }
        
        while(k-- > 0) {
            stack.pop();
        }
        
        for(char num:stack) {
            sb.append(num);
        }
      
        
        return sb.toString();
    }
}

