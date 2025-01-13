import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int count = 0;
        
        while(!s.equals("1")) {
            int size = s.length();
            s = s.replaceAll("0","").trim();
            zeroCount += size - s.length();
            s = Integer.toBinaryString(s.length());
            count++;
        }

        answer[0] = count;
        answer[1] = zeroCount;
        return answer;
    }
}