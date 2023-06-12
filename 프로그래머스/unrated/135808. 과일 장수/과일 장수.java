import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] scores = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scores, Collections.reverseOrder());
        for(int i=0; i<scores.length; i+=m) {
            if(i+m-1>=score.length) break;
            else answer += scores[i+m-1]*m;
        }
        return answer;
    }
}