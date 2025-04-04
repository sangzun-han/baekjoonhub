import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;
        for(char c: s.toCharArray()) {
            if(c ==' ') {
                sb.append(" ");
                isStart = true;
            } else {
                if(isStart) {
                    sb.append(Character.toUpperCase(c));
                    isStart = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
            
           
        }
        return sb.toString();
    }
}