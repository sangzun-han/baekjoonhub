import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
    
        for(int i=0; i<numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        
        list.sort((a,b) -> (b+a).compareTo(a+b));
        
        if(list.get(0).equals("0")) return "0";
        
        for(int i=0; i<list.size(); i++) {
            answer += list.get(i);
        }
     

        return answer;
    }
}