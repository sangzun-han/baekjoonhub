import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> str1Map = new HashMap<>();
        HashMap<String, Integer> str2Map = new HashMap<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        
        for(int i=0; i<str1.length()-1; i++) {
            String two = str1.substring(i,i+2);
            if(isAlpha(two)) {
                str1Map.put(two, str1Map.getOrDefault(two, 0) + 1);
            } 
        }
        
        for(int i=0; i<str2.length()-1; i++) {
            String two = str2.substring(i, i+2);
            if(isAlpha(two)) {
                str2Map.put(two, str2Map.getOrDefault(two, 0) + 1);
            }
        }
        
        int intersection = 0;
        int union = 0;
        
        // 교집합 구하기
        for(String key: str1Map.keySet()) {
            if(str2Map.containsKey(key)) {
                intersection += Math.min(str1Map.get(key), str2Map.get(key));
            }
            union += str1Map.get(key);
        }
        
        // 합집합 구하기
        for(String key: str2Map.keySet()) {
            // str2에만 존재하는 문자
            if(!str1Map.containsKey(key)) {
                union += str2Map.get(key);
            } else { // str2, str1에도 존재하는 문자열 그런데 위에서 이미 str1의값을 더했음 그러니까 max값을 더해야됨, str2- str1값만큼만 뺀걸 더하면됨 음수라면 str1의 값이 더 많은거니까 이미 더한상태임
                union += Math.max(0, str2Map.get(key) - str1Map.get(key));
            }
        }
        
        
        if(union==0) return 65536;
        
        double j = (double)intersection/union;

        return (int) (j*65536);
    }
    
    private boolean isAlpha(String s) {
        for(char ch: s.toCharArray()) {
            if(!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }
}