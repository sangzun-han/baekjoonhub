import java.util.*;

class Solution {
  
    public int solution(String str1, String str2) {
        int intersection = 0;
        int union = 0;
        
        String s1 = str1.toUpperCase();
        String s2 = str2.toUpperCase();
        
        Map<String, Integer> s1Map = new HashMap<>();
        Map<String, Integer> s2Map = new HashMap<>();
        Set<String> merge = new HashSet<>();
        
        for(int i=0; i<s1.length()-1; i++) {
            String s = s1.charAt(i)+""+s1.charAt(i+1);
            if(isAlpha(s)) {
                s1Map.put(s, s1Map.getOrDefault(s, 0) + 1);
            }
        }
        
        for(int i=0; i<s2.length()-1; i++) {
            String s = s2.charAt(i)+""+s2.charAt(i+1);
            if(isAlpha(s)) {
                s2Map.put(s, s2Map.getOrDefault(s, 0) + 1);
            }
        }
      
        merge.addAll(s1Map.keySet());
        merge.addAll(s2Map.keySet());
        
        for(String key : merge) {
            int s1Count = s1Map.getOrDefault(key, 0);
            int s2Count = s2Map.getOrDefault(key, 0);
            intersection += Math.min(s1Count, s2Count);
            union += Math.max(s1Count, s2Count);
        }
        
        if(union == 0) return 65536;
        
        double jaccard = (double) intersection / union;
        return (int) (jaccard * 65536);
    }
    
    private boolean isAlpha(String s) {
        char[] c = s.toCharArray();
        
        for(int i=0; i<c.length; i++) {
            if(!Character.isAlphabetic(c[i])) {
                return false;
            }
        }
        
        return true;
    }
}