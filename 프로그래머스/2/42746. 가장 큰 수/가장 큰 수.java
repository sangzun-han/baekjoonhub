import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        
        Collections.sort(list, new Comparator<String>(){
            public int compare(String s1, String s2) {                
                return (s2+s1).compareTo(s1+s2);
            }   
        });
        
        if(list.get(0).equals("0")) return "0";
        
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
        }
            
        return sb.toString();
    }
}