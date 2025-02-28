import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++) {
            int schedule = convertTime(schedules[i]); // 출근 희망 시간
            boolean isLate = false;
            
            for(int j=0; j<timelogs[i].length; j++) {
                int currentDay = (j+startday)%7;
                if(currentDay==6 || currentDay==0) continue;
                int realTime = convertTime(timelogs[i][j]); // 실제 도착 시간
                
                if(schedule+10 < realTime) {
                    isLate = true;
                    break;
                }
            }
            if(!isLate) answer++;
            
        }
    
        return answer;
    }
    
    public int convertTime(int time) {
        int hour = time / 100;
        int minute = time % 100;
        return (hour * 60) + minute;
    }
}