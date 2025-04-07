import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length * 5;
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toUpperCase();
            
            if(queue.contains(city)) {
                queue.remove(city);
                queue.offer(city);
                answer++;
            } else {
                if(queue.size() >= cacheSize) {
                    queue.remove(queue.poll());   
                }
                queue.offer(city);
                answer+=5;
            }
        }
        return answer;
    }
}