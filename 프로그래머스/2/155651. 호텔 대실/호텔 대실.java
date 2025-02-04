import java.util.*;

class Time implements Comparable<Time>{
    int startTime;
    int endTime;
    
    Time(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    @Override
    public int compareTo(Time t) {
        return this.startTime - t.startTime;
    }
}

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Time> roomTimes = new ArrayList<>();
  
        for(int i=0; i<book_time.length; i++) {
            int startTime = convertTime(book_time[i][0]);
            int endTime = convertTime(book_time[i][1]) + 10;
            roomTimes.add(new Time(startTime, endTime));
        }
        Collections.sort(roomTimes);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(Time t: roomTimes) {
            int start = t.startTime;
            int end = t.endTime;
            
            // 재사용
            if(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            
            pq.offer(end);
        }
       
        return pq.size();
    }
    
    public int convertTime(String time) {
        String[] t = time.split(":");
        return (Integer.parseInt(t[0]) * 60) + Integer.parseInt(t[1]);
    }
}