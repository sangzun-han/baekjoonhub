import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            if(cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += 1;
            } else {
                if(cacheSize <= cache.size() && cache.size() > 0) {
                    cache.removeFirst();
                }
                if(cacheSize > 0) {
                    cache.add(city);
                }
                answer += 5;
            }
        }
        return answer;
    }
}