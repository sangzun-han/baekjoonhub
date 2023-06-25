import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            if(hashMap.containsKey(clothes[i][1])) {
                int count = hashMap.get(clothes[i][1]);
                hashMap.put(clothes[i][1],count+1);
            }  else {
                hashMap.put(clothes[i][1], 1);
            }
        }
        
        for(String value: hashMap.keySet()) {
            answer = answer * (hashMap.get(value)+1);
        }
        return answer-1;
    }
}

