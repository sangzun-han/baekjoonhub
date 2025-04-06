import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int size = s.length();
        
        for(int i=0; i<size; i++) {
            String rotate = s.substring(i) + s.substring(0,i);
            
            if(isValid(rotate)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isValid(String rotate) {
        char[] c = rotate.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<c.length; i++) {
            if(c[i]=='[' || c[i]=='(' || c[i]=='{') {
                stack.push(c[i]);
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                
                if(c[i]==']' && top!='[' || c[i]=='}' && top!='{' || c[i]==')' && top!='(') return false;
                
            }
        }
        
        return stack.isEmpty();
    }
}