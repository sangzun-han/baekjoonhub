import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> recordMaps = new TreeMap<>();
        
        int primaryTime = fees[0];
        int primaryPrice = fees[1];
        int timePer = fees[2];
        int pricePer = fees[3];
        
        for(int i=0; i<records.length; i++) {
            String[] recordSplit = records[i].split(" ");
            int time = minuteFromTime(recordSplit[0]);
            int carNumber = Integer.parseInt(recordSplit[1]);
            List<Integer> recordMapsList = recordMaps.getOrDefault(carNumber, new ArrayList<>());
            recordMapsList.add(time);
            recordMaps.put(carNumber, recordMapsList);
        }
        
        for(int carNumber : recordMaps.keySet()) {
            
            int totalTime = 0;
            
            List<Integer> parkTime = recordMaps.get(carNumber);
            if(parkTime.size()%2 == 1) {
                parkTime.add(minuteFromTime("23:59"));
            }
            
            for(int i=0; i<parkTime.size()-1; i+=2) {
                totalTime += parkTime.get(i+1) - parkTime.get(i);
            }
            
            int price = primaryPrice;
            
            if(totalTime > primaryTime) {
                int remainTime = totalTime - primaryTime;
                price += remainTime / timePer * pricePer;
                if(remainTime % timePer > 0) price += pricePer;
            }
            list.add(price);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int minuteFromTime(String time) {
        String[] timeSplit = time.split(":");
        return (Integer.parseInt(timeSplit[0])*60) + Integer.parseInt(timeSplit[1]);
    }
}