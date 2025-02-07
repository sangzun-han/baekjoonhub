import java.util.*;

class Solution {
    public String solution(String p) {
        
        if(p.length() == 0) return "";
        int check = 0;
        int index = 0;
        String u;
        String v;
        
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i)=='(') check++;
            else if(p.charAt(i)==')') check--;
            index++;
            if(check==0) {
                u = p.substring(0, index);
                v = p.substring(index);
                // u는 올바른 괄호 문자열인가?
                if(isValid(u)) {
                    return u + solution(v);
                } else {
                    StringBuilder sb = new StringBuilder();
                    // 4-1
                    sb.append("(");
                    // 4-2
                    sb.append(solution(v));
                    // 4-3
                    sb.append(")");
                    // 4-4-1
                    u = u.substring(1, u.length() - 1);
                    // 4-4-2
                    sb.append(reverse(u));

                    return sb.toString();
                }
            }
                    
        }
        
        String answer = "";
        return answer;
    }
    
    public boolean isValid(String u) {
        int check = 0;
        
        for(int i=0; i<u.length(); i++) {
            if(check==-1) return false;
            if(u.charAt(i)=='(') check++;
            else if (u.charAt(i)==')') check--;
        }
        
        return (check < 0 || check > 0) ? false : true;
    }
    
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==')') sb.append("(");
            else if (s.charAt(i)=='(') sb.append(")");
        }
        
        return sb.toString();
    }
}