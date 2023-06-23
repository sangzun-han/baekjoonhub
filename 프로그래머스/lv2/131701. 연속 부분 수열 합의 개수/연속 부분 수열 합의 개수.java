import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int size = 1;
        HashSet<Integer> set = new HashSet<>();
        while(size <= elements.length) {
            for(int i=0; i<elements.length; i++) {
                int sum = 0;
                
                for(int j=i; j<i+size; j++) {
                    sum += elements[j%elements.length];
                }
                set.add(sum);
            }            
            size++;
        }
        answer = set.size();
        return answer;
    }
}