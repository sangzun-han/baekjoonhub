import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(count < 0) {
                answer = false;
                return answer;
            }
            if(s.charAt(i)=='(') count++;
            else count--;
        }
        if(count==0) answer = true;
        else answer = false;
     
        return answer;
    }
}