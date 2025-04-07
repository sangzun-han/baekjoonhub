import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
    
        int answer = 0;
        Map<String, Integer> answerMap = new HashMap<>();
        
        for(int i=0; i<want.length; i++) {
            answerMap.put(want[i], number[i]);
        }
        
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<=discount.length - 10; i++) {
            for(int j=0; j<10; j++) {
                String product = discount[i+j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }        
            boolean isPossible = true;
            for(String key: map.keySet()) {
                if(answerMap.getOrDefault(key,0) != map.getOrDefault(key, 11)) {
                    isPossible = false;
                    break;
                }
            }
            map.clear();
            if(isPossible) answer++;
        }
        return answer;
    }
}

