import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++) {
            int 귤크기 = tangerine[i];
            map.put(귤크기, map.getOrDefault(귤크기, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int key: map.keySet()) {
            list.add(map.get(key));
        }
        
        Collections.sort(list);

        
        for(int i=list.size()-1; i>=0; i--) {
            int count = list.get(i);
            if(k-count < 0) {
                answer++;
                return answer;
            }
            else if (k-count > 0) {
                k -= count;
                answer++;
            } else if(k-count==0) {
                answer++;
                break;
            }
        }

        return answer;
    }
}
