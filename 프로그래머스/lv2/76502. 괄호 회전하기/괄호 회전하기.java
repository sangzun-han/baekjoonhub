import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int d=0; d<s.length(); d++) {
            boolean flag = false;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='(') {
                    stack.push(s.charAt(i));
                    flag = true;
                } else if(!stack.isEmpty() && s.charAt(i)==']' && stack.peek()=='[') {
                    stack.pop();
                } else if(!stack.isEmpty() && s.charAt(i)=='}' && stack.peek()=='{') {
                    stack.pop();
                } else if(!stack.isEmpty() && s.charAt(i)==')' && stack.peek()=='(') {
                    stack.pop();
                }   
            }
            if(flag && stack.isEmpty()) answer++;
            s = s.substring(1,s.length()) + s.substring(0,1);
            stack.clear();
        }
            
    
        return answer;
    }
}