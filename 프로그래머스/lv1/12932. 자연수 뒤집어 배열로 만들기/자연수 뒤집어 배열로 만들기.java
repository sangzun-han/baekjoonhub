import java.util.*;

class Solution {
    public int[] solution(long n) {
        String number = String.valueOf(n);
        int size = number.length();
        int[] answer = new int[size];
        
        for(int i=0; i<size; i++) {
            answer[i] = number.charAt(size-i-1) -'0';
        }
        
        return answer;
    }
}