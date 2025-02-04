import java.util.*;

class Time implements Comparable<Time>{
    int time;
    int type;
    
    Time(int time, int type) {
        this.time = time;
        this.type = type;
    }
    
    @Override
    public int compareTo(Time t) {
        if(this.time == t.time) {
            return this.type - t.type;
        }
        return this.time - t.time;
    }
}

class Solution {
    public int solution(String[][] book_time) {
        List<Time> roomTimes = new ArrayList<>();
  
        for(int i=0; i<book_time.length; i++) {
            int startTime = convertTime(book_time[i][0]);
            int endTime = convertTime(book_time[i][1]) + 10;
            roomTimes.add(new Time(startTime, 1));
            roomTimes.add(new Time(endTime, -1));
        }
        Collections.sort(roomTimes);
        
        int currentRooms = 0;
        int maxRooms = 0;
        
        for(Time time: roomTimes) {
            currentRooms += time.type;
            maxRooms = Math.max(maxRooms, currentRooms);
        }
        
        return maxRooms;
    }
    
    public int convertTime(String time) {
        String[] t = time.split(":");
        return (Integer.parseInt(t[0]) * 60) + Integer.parseInt(t[1]);
    }
}