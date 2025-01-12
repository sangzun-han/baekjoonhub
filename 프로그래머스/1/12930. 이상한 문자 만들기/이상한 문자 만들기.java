import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String answer = "";
        int index = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c==' ') {
                sb.append(" ");
                index = 0;
                
            }
            
            else if (index%2==0) {
                sb.append(Character.toUpperCase(c));
                index++;
            } else {
                sb.append(Character.toLowerCase(c));
                index++;
            }
    
        }
        return sb.toString();
    }
}