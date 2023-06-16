import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String,Integer> hashMap = new HashMap<>();
      
        for(int i=0; i<words.length; i++) {
           
            if(hashMap.containsKey(words[i])) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                return answer;
            } else {
                if(i==0) hashMap.put(words[i],1);
                else {
                    String pre = words[i-1];
                    String next = words[i];
                    int preLength = pre.length();
                    int nextLength = next.length();
                    
                    if(pre.charAt(preLength-1) == next.charAt(0)) hashMap.put(words[i],1);
                    else {
                        
                        answer[0] = i%n+1;
                        answer[1] = i/n+1;
                       
                        return answer;
                    }
                }
            }
        }
        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}