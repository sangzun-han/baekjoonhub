import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = -1;
        Stack<Character> start = new Stack<>();
        Stack<Character> end = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            start.push(s.charAt(i));
        }
        
        while(!start.isEmpty()) {
            end.push(start.pop());
            if(end.size()>=2) {
                char a = end.pop();
                char b = end.pop();
                if(a!=b) {
                    end.push(b);
                    end.push(a);
                }
            }
        }
        
        if(end.size()==0) answer = 1;
        else answer = 0;

        return answer;
    }
}