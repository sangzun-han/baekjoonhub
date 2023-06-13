import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int temp = 0;
        for(int i=0; i<A.length; i++) {
            answer = answer + A[i] * B[B.length-1-i];    
            temp = temp + A[A.length-1-i] * B[i];
        }
        answer = Math.min(answer,temp);
        return answer;
    }
}