import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        
        for(int i=0; i<participant.length; i++) {
            hash.put(participant[i], hash.getOrDefault(participant[i],0)+1);
        }
        
        for(int i=0; i<completion.length; i++) {
            hash.put(completion[i], hash.getOrDefault(completion[i],0)-1);
        }
        
        for(String s: hash.keySet()) {
            if(hash.get(s)>0) {
                answer = s;
            }
        }
        
        return answer;
    }
}