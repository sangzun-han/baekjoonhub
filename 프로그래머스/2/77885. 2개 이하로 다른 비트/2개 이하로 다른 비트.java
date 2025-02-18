import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        // XOR 연산 -> 1의 개수가 2개 이하면 되는듯? 문제는 범위 : 10^15
        for(int i=0; i<numbers.length; i++) {
            long number = numbers[i];
            long next = number;
            if(number%2==0) {
                answer[i] = number + 1;
            } else {
                int count = 0;
                while(next % 2 == 1) {
                    count++;
                    next /= 2;
                }
                answer[i] = number + (long) Math.pow(2, count-1);
            }
        }
        
        return answer;
    }
}