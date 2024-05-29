import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        ArrayList<Character> list = new ArrayList<>();
        
        for(int i=0; i<s.length(); i++) {
            list.add(s.charAt(i));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(char c: list) {
            answer += c;
        }
        return answer;
    }
}