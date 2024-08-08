import java.util.*;

class Solution {
    public String solution(String s, int n) {
         
        StringBuilder sb = new StringBuilder();
        
         for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
             System.out.println(ch);
            if (Character.isUpperCase(ch)) {
                sb.append((char) ((ch - 'A' + n) % 26 + 'A'));
            } else if (Character.isLowerCase(ch)) {
                sb.append((char) ((ch - 'a' + n) % 26 + 'a'));
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}