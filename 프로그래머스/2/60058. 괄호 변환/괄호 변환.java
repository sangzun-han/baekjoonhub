import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = recursive(p);
        return answer;
    }

    public String recursive(String p) {

        if(p.equals("")) return "";
        String ans = "";
        
        int check = 0;
        String u = "";
        String v = "";
        
        for(int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            if(c=='(') check++;
            else if (c==')') check--;
            
            // 균형 잡힌 문자열 i까지 도달했을 때, u,v로 나눈다.
            if(check==0) {
                u = p.substring(0, i+1);
                v = p.substring(i+1);
                break;
            }   
        }
        
        // u가 올바른 괄호 문자열이라면?
        if(isValid(u)) {
            return u + recursive(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(recursive(v));
            sb.append(")");
            u = u.substring(1, u.length() - 1);
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < u.length(); j++) {
                char ch = u.charAt(j);
                if (ch == '(') temp.append(')');
                else temp.append('(');
            }
            sb.append(temp.toString());
            return sb.toString();
        }
    }
    
    public boolean isValid(String u) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty(); 
    }   

}
