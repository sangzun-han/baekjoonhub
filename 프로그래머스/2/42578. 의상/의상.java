import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        // 안입는 경우도 있다.
        for(int i=0; i<clothes.length; i++) {
            String cloth = clothes[i][0];
            String kind = clothes[i][1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        
        for(int n: map.values()) {
            answer = (n+1) * answer;
        }
        
        return answer - 1;
    }
    
}




