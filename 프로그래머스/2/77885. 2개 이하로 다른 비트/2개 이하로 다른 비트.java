import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            long number = numbers[i];
            long next = number;
            int count = 0;
            if(number%2==0) {
                answer[i] = number + 1;
            } else {
                while(next%2==1) {
                    count++;
                    next /= 2;
                }
                answer[i] = number + (long)Math.pow(2, count-1);
            }
        }
        return answer;
    }
}