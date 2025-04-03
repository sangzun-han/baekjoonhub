import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] splitS = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<splitS.length; i++) {
            max = Math.max(Integer.parseInt(splitS[i]), max);
            min = Math.min(Integer.parseInt(splitS[i]), min);
        }
        answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}