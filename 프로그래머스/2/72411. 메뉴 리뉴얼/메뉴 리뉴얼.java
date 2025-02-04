import java.util.*;

class Solution {
    
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        for(int cos: course) {
            Map<String, Integer> courseMap = new HashMap<>();
            for(String order: orders) {
                char[] orderedArr = order.toCharArray();
                Arrays.sort(orderedArr);
                String sortedOrderedArr = String.valueOf(orderedArr);
                
                comb(sortedOrderedArr, cos, 0, "", courseMap);
            }
            
            
            // 첫 반복을 돌고나면 가장 많이 나온 조합의 갯수를 하나 찾는다.
            int count = 0;
            for(int n: courseMap.values()) {
                count = Math.max(n,count);
            }
            
            if(count < 2) continue;
            
            for(String key: courseMap.keySet()) {
                if(courseMap.get(key)==count) {
                    result.add(key);
                }
            }
        }
        Collections.sort(result);
         String[] answer = new String[result.size()];
        
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    
    public void comb(String order, int count, int index, String current, Map<String,Integer> courseMap) {
        if(order.length() < count) return;
        
        if(count == current.length()) {
            courseMap.put(current, courseMap.getOrDefault(current,0) + 1);
            return;
        }
        
        for(int i=index; i<order.length(); i++) {
            comb(order, count, i+1, current + order.charAt(i), courseMap);
        }
    }
    
  
}