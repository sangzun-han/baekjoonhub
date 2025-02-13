import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<Integer, List<Integer>> carRecord = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        
        int primaryTime = fees[0];
        int primaryPrice = fees[1];
        int perTime = fees[2];
        int perPrice = fees[3];
        
        for(int i=0; i<records.length; i++) {
            String[] record = records[i].split(" ");
            int carNumber = Integer.parseInt(record[1]);
            int time = convertTime(record[0]);
            
            List<Integer> timeRecord = carRecord.getOrDefault(carNumber, new ArrayList<>());
            timeRecord.add(time);
            carRecord.put(carNumber, timeRecord);
        }
        
        for(int carNumber: carRecord.keySet()) {
            int totalPrice = 0;
            int totalTime = 0;
            List<Integer> times = carRecord.get(carNumber);
            // 출차가 없다.
            if(times.size()%2==1) {
                times.add(convertTime("23:59"));
            }
            
            for(int i=0; i<times.size(); i+=2) {
                int inTime = times.get(i);
                int outTime = times.get(i+1);
                totalTime += outTime - inTime;   
            }
            
            totalPrice = primaryPrice;
            totalTime -= primaryTime;
            
            if(totalTime > 0) {
                if(totalTime % perTime != 0) {
                    totalPrice += (totalTime / perTime) * perPrice + perPrice;
                } else {
                    totalPrice += (totalTime / perTime) * perPrice;
                }  
            }
            list.add(totalPrice);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }   
        
        return answer;
    }
    
    public int convertTime(String time) {
        String[] timeSplit = time.split(":");
        int hour = Integer.parseInt(timeSplit[0]);
        int minute = Integer.parseInt(timeSplit[1]);
        
        return hour * 60 + minute;
    }
}