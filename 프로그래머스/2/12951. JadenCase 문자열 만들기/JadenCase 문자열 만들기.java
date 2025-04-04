import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] sSplit = s.split(" ", -1);
        
        
        for(int i=0; i<sSplit.length; i++) {
            System.out.println(sSplit[i]);
            if(sSplit[i].length()==0) sb.append("");
            else {
                sSplit[i] = sSplit[i].substring(0,1).toUpperCase() + sSplit[i].substring(1).toLowerCase();
                sb.append(sSplit[i]);
            }
            if(i!=sSplit.length-1) sb.append(" ");
        }
        
        return sb.toString();
    }
}