import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> timeList = new ArrayList<>();
        TreeMap<String, List<Integer>> parkRecord = new TreeMap<>();
        List<Integer> answerList = new ArrayList<>();
        
        int basicTime = fees[0];
        int basicPrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];
        
        
        for(int i=0; i<records.length; i++) {
            String[] s = records[i].split(" ");
            int time = hourToMinute(s[0]);
            String number = s[1];
            List<Integer> list = parkRecord.getOrDefault(number, new ArrayList<>());
            list.add(time);
            parkRecord.put(number, list);
        }
        
        for(String key: parkRecord.keySet()) {
            List<Integer> times = parkRecord.get(key);
            int price = 0;
            int prefixTime = 0;
            if(times.size()%2 == 1) {
                times.add(hourToMinute("23:59"));
            }

            for(int i=0; i<times.size(); i++) {
                System.out.print(times.get(i)+" ");
            }
            
            while(times.size() != 0) {
                int out = times.get(1);
                int in = times.get(0);
                int time = out - in;
                prefixTime += time;                
                times.remove(0);
                times.remove(0);
            }
            
             if(prefixTime <= basicTime) {
                    price += basicPrice;
                    prefixTime -= basicTime;
                } else {
                    price += basicPrice;
                    prefixTime -= basicTime;
                    if(prefixTime % unitTime == 0) {
                        price += (int)(prefixTime / unitTime) * unitPrice;
                    } else {
                        price += (int)(prefixTime / unitTime) * unitPrice;
                        price += unitPrice;
                }
            }
            answerList.add(price);
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    
    public int hourToMinute(String time) {
        String[] s = time.split(":");
        int hour = Integer.parseInt(s[0]);
        int minute = Integer.parseInt(s[1]);
        
        return hour*60 + minute;
    }
}