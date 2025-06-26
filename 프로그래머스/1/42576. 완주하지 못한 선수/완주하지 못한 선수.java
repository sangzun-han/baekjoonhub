import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {        
        String answer = "";
        
        Map<String, Integer> 완주한사람 = new HashMap<>();
        
        for(int i=0; i<completion.length; i++) {
            String completed = completion[i];  
            완주한사람.put(completed, 완주한사람.getOrDefault(completed, 0) + 1);
        }
        
        for(int i=0; i<participant.length; i++) {
            String p = participant[i];
            int count = 완주한사람.getOrDefault(p, 0) - 1;
            완주한사람.put(p, count);
        }
        
        for(String key: 완주한사람.keySet()) {
            int value = 완주한사람.get(key);
            if(value < 0) answer = key;
        }
        
        return answer;
    }
}

