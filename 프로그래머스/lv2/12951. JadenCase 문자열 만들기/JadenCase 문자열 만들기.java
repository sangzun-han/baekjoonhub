import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.toLowerCase().split(" ");
        String answer = "";
        for(int i=0; i<str.length; i++) {
           if(str[i].length()==0) {
               sb.append(" ");
               continue;
           }
            sb.append(str[i].substring(0,1).toUpperCase());
            sb.append(str[i].substring(1,str[i].length()));
            sb.append(" ");
        }
        if(!" ".equals(s.substring(s.length()-1, s.length()))) {
            sb.deleteCharAt(sb.lastIndexOf(" "));
        }
        
        answer = sb.toString();
        return answer;
    }
}