import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i=0; i<targets.length; i++) {
            String target = targets[i];
            int result = 0;
            
            for(int j=0; j<target.length(); j++) {
                int idx = Integer.MAX_VALUE;
                
                for(String key: keymap) {
                    int tempIdx = key.indexOf(target.charAt(j));
                    if(tempIdx==-1) continue;
                    idx = Math.min(idx, tempIdx+1);
                }
                if(idx==Integer.MAX_VALUE) {
                    result = -1;
                    break;
                }
                 result += idx;
            }
           
            answer[i] = result;
        }
        
        
        return answer;
    }
}
