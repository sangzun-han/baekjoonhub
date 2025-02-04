import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        
        for(int i=0; i<weights.length; i++) {
            double weight = (double) weights[i];
            answer += map.getOrDefault(weight, 0) 
                + map.getOrDefault((weight * 2) / 3, 0)
                + map.getOrDefault((weight * 3) / 2, 0)
                + map.getOrDefault((weight * 3) / 4, 0)
                + map.getOrDefault((weight * 4) / 3, 0)
                + map.getOrDefault(weight / 2, 0)
                + map.getOrDefault(weight * 2, 0);
            
            map.put(weight, map.getOrDefault(weight,0) + 1);
            
        }
        return answer;
    }
}