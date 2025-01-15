import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static char[] alpha = {'A','E','I','O','U'};
    
    public int solution(String word) {
        recursive("", 0);
        Collections.sort(list);
        
        int index = list.indexOf(word);
        return index+1;
    }
    
    public void recursive(String cur, int depth) {
        if(depth > 5) {
            return;
        }
        
        if(!cur.isEmpty()) {
            list.add(cur);
        }
        
        for(char a: alpha) {
            recursive(cur+a, depth+1);
        }
        
    }
}