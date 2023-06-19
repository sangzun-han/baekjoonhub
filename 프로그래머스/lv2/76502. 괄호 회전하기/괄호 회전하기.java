import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length()-1; i++) {
            stack.clear();
            boolean flag = false;
            
            for(int j=0; j<s.length(); j++) {
               if(s.charAt(j)=='[' || s.charAt(j)=='(' || s.charAt(j)=='{') {
                    stack.push(s.charAt(j));
                    flag = true;
                } else if(!stack.isEmpty() &&s.charAt(j)==']' && stack.peek()=='[') {
                    stack.pop();
                } else if(!stack.isEmpty() &&s.charAt(j)=='}' && stack.peek()=='{') {
                    stack.pop();
                } else if(!stack.isEmpty() &&s.charAt(j)==')' && stack.peek()=='(') {
                    stack.pop();
                }
            }
            
            if(flag && stack.isEmpty()) answer++;
            s = s.substring(1,s.length()) + s.substring(0,1);
        }
        return answer;
    }
}