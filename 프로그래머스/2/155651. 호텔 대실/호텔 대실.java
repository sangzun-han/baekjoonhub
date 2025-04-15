import java.util.*;

class Hotel{
    int startTime;
    int endTime;
    
    Hotel(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
}
class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Hotel> pq = new PriorityQueue<>((a,b) -> a.startTime - b.startTime);
        PriorityQueue<Integer> ing = new PriorityQueue<>();
        int answer = 0;
        
        for(int i=0; i<book_time.length; i++) {
            int start = convertHourFromMinute(book_time[i][0]);
            int end = convertHourFromMinute(book_time[i][1]);
            pq.offer(new Hotel(start, end));
        }
        
        
        while(!pq.isEmpty()) {
            if(ing.isEmpty()) {
                ing.offer(pq.poll().endTime);
                answer++;
            }
            
            if(!ing.isEmpty() && !pq.isEmpty() && ing.peek() + 10 <= pq.peek().startTime) {
                ing.poll();
                ing.offer(pq.poll().endTime);
            }
            
            if(!ing.isEmpty() && !pq.isEmpty() && ing.peek() + 10 > pq.peek().startTime) {
                ing.offer(pq.poll().endTime);
                answer++;
            }
            
            
        }
        
        return answer;
    }
    public int convertHourFromMinute(String time) {
        String[] tSplit = time.split(":");
        int hour = Integer.parseInt(tSplit[0]);
        int minute = Integer.parseInt(tSplit[1]);
        
        return hour * 60 + minute;
    }
}
 