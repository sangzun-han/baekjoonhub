import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> setGem = new HashSet<>();
        Map<String,Integer> jewel = new HashMap<>();
        
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
      
        for(int i=0; i<gems.length; i++) {
            setGem.add(gems[i]);
        }
        
        while(right < gems.length) {
            jewel.put(gems[right], jewel.getOrDefault(gems[right], 0) + 1);
            right++;
            
            while(jewel.size() == setGem.size()) {
                if(right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }
                
                jewel.put(gems[left], jewel.get(gems[left]) - 1);
                if(jewel.get(gems[left]) == 0) {
                    jewel.remove(gems[left]);
                }
                
                left++;
            }            
        }
        return answer;
    }
}