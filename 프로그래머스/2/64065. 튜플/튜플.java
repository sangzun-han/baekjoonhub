import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] subset = s.split("},");
        
        for(int i=0; i<subset.length; i++) {
            subset[i] = subset[i].replace("{","").replace("}","").trim();
            
        }
        
        Arrays.sort(subset, (a,b) -> a.length() - b.length());
    
        
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<subset.length; i++) {
            String[] num = subset[i].split(",");
            
            for(String str: num) {
                
                if(str.equals(",")) continue;
                int convertNum = Integer.parseInt(str);
                
                if(!set.contains(convertNum)) {
                    set.add(convertNum);
                    list.add(convertNum);
                }
            
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}