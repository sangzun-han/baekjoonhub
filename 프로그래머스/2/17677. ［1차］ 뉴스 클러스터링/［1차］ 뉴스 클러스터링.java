import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int union = 0;
        int intersection = 0;
        
        Map<String, Integer> setA = new HashMap<>();
        Map<String, Integer> setB = new HashMap<>();        
        Set<String> keys = new HashSet<>();
        
        for(int i=0; i<str1.length()-1; i++) {
            if(Character.isLetter(str1.charAt(i)) && Character.isLetter(str1.charAt(i+1))) {
                String s = str1.substring(i,i+2).toUpperCase();
                setA.put(s, setA.getOrDefault(s, 0) + 1);
            }
        }
        
        for(int i=0; i<str2.length()-1; i++) {
            if(Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i+1))) {
                String s = str2.substring(i,i+2).toUpperCase();
                setB.put(s, setB.getOrDefault(s, 0) + 1);
            }
        }
        
        for(String key: setA.keySet()) {
            keys.add(key);
        }
        
        for(String key: setB.keySet()) {
            keys.add(key);
        }
        
        
        for(String key: keys) {
            int aCount = setA.getOrDefault(key, 0);
            int bCount = setB.getOrDefault(key, 0);
            
            union += Math.max(aCount,bCount);
            
            if(aCount==0 || bCount==0) continue;
            intersection += Math.min(aCount, bCount);
        }
        
        if(union==0) return 65536;
        else {
            double d = ((double)intersection/(double)union);
            answer = (int)(d*65536);
        }
        
        return answer;
    }
}
