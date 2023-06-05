import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int[] xArray = new int[10];
        int[] yArray = new int[10];
        
        for(int i=0; i<X.length(); i++) {
            int num = X.charAt(i)-'0';
            xArray[num]++;
        }
        
        for(int i=0; i<Y.length(); i++) {
            int num = Y.charAt(i)-'0';
            yArray[num]++;
        }
        
        for(int i=9; i>=0; i--) {
            while(xArray[i]>0 && yArray[i]>0) {
                xArray[i]--;
                yArray[i]--;
                sb.append(i);
            }
        }
        
        if(sb.toString().equals("")) return "-1";
        if(sb.toString().substring(0,1).equals("0")) return "0";
        else {
            answer = sb.toString();
            return answer;
        }
    }
}