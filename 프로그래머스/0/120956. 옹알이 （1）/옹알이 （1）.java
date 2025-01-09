import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] replaces = new String[]{"aya","ye","woo","ma"};
        
        for(int i=0; i<babbling.length; i++) {
            for(int j=0; j<replaces.length; j++) {
               babbling[i] =  babbling[i].replace(replaces[j], " ");
            }
        }
        
        for(int i=0; i<babbling.length; i++) {
            String s = babbling[i].replace(" ","");
            if(s.length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}