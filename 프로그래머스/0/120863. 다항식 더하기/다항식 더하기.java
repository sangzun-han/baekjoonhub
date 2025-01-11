import java.util.*;

class Solution {
    public String solution(String polynomial){
        StringBuilder answer = new StringBuilder();
        
        String[] poly = polynomial.split(" ");
        int xCount = 0;
        int number = 0;   
        
        for(String p: poly) {
            if(p.equals("+")) continue;
            if(p.contains("x")) {
                // x만 존재한경우
                if(p.equals("x")) {
                    xCount++;
                } else {
                    // 계수
                    xCount += Integer.parseInt(p.replace("x", ""));
                }
            } else {
                number += Integer.parseInt(p);
            }
        }
        
        
        if(xCount != 0) {
            if(xCount == 1){
                answer.append("x");
            } else {
                answer.append(xCount).append("x");
            }
        }
        
        if(number != 0) {
            if(answer.length() > 0) {
                answer.append(" + ");
            }
            answer.append(number);
            
        }
        return answer.toString();
    }
}