import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>(); 
        Map<Integer, Integer> map = new HashMap<>();
    
        for(int top: topping) {
            map.put(top, map.getOrDefault(top, 0) + 1);
        }
        
        for(int top: topping) {
            set.add(top);
            map.put(top, map.getOrDefault(top, 0) -1);
            
            if(map.get(top) == 0) {
                map.remove(top);
            }
            
            if(set.size() == map.size()) {
                answer++;
            }
        }
        
    
        return answer;
    }
}