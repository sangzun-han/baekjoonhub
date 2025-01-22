import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = new String[]{"aya","ye","woo","ma"};
        
        for(String word: babbling) {
            String next = word;
            
            for(String w: words) {
                if(next.contains(w + w)) {
                    break;
                }
                next = next.replace(w," ");
            }
            
            if(next.trim().isEmpty()) {
                answer++;
            }
        }
    
        return answer;
    }
}

