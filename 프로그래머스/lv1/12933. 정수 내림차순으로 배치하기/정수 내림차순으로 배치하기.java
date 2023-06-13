import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Long> list = new ArrayList<>();
        
        long N = n;
        System.out.println(N);
        long M = 0;
        while(true) {
            M = N%10;
            N = N/10;

            list.add(M);
            if(N==0) break;
        }
        
        Collections.sort(list);
        

        for(int i=list.size()-1; i>=0; i--) {
            
            long digit = (long)(Math.pow(10,i));
            answer += digit*list.get(i);
        }
        
        return answer;
    }
}