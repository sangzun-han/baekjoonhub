import java.util.*;

class Solution {
    static int K =0;
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++) {
            if(hashMap.containsKey(tangerine[i])) {
                int count = hashMap.get(tangerine[i]);
                hashMap.put(tangerine[i], count+1);
            } else {
                hashMap.put(tangerine[i],1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(Integer value: hashMap.keySet()) {
            list.add(hashMap.get(value));
        }
        
        list.sort(Collections.reverseOrder());

        for(Integer value: list) {
            System.out.println(value);
            answer++;
            k -= value;
            if(k <= 0) break;
        }
        
        return answer;
    }
}