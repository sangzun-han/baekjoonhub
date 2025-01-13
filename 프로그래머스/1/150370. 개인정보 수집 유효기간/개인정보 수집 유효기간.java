import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        String[] todaySplit = today.split("\\.");
        int year = Integer.parseInt(todaySplit[0]);
        int month = Integer.parseInt(todaySplit[1]);
        int day = Integer.parseInt(todaySplit[2]);
        int todayLine = (year*12*28) + (month*28) + day;
        
        for(int i=0; i<terms.length; i++) {
            String[] parts = terms[i].split(" ");
            String type = parts[0];
            Integer exp = Integer.parseInt(parts[1]);
            hashMap.put(type, exp);
        }
        
        for(int i=0; i<privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
        
            String date = parts[0];
            Integer exp = hashMap.get(parts[1]);
            
            Integer deadLine = calc(date, exp);
            
            if(todayLine >= deadLine) {
                list.add(i+1);
            }
            
        }
        
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private Integer calc(String date, Integer exp) {
        String[] parts = date.split("\\.");
        
        Integer year = Integer.parseInt(parts[0]);
        Integer month = Integer.parseInt(parts[1]);
        Integer day = Integer.parseInt(parts[2]);
        
        
        // 유효기간까지 더한 모든 일 수
        return (year * 12 * 28) + (month*28) + (exp*28) + day;
    }
    
}