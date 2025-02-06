import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> alphaToIntDict = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0; i<alphabet.length(); i++) {
            String alpha = String.valueOf(alphabet.charAt(i));
            alphaToIntDict.put(alpha, i+1);
        }
        
        int size = msg.length();
        int index = 0;
        int dictSize = 27;
        
        while(size > index){
            String alpha = String.valueOf(msg.charAt(index));
            int prev = alphaToIntDict.get(alpha);
            int nextIndex = index + 1;
            while(nextIndex < size) {
                String nextAlpha = alpha + String.valueOf(msg.charAt(nextIndex));
                if(!alphaToIntDict.containsKey(nextAlpha)) {
                    alphaToIntDict.put(nextAlpha, dictSize);
                    dictSize++;
                    break;
                }
                alpha = nextAlpha;
                prev = alphaToIntDict.get(alpha);
                nextIndex++;
            }
            
            answerList.add(prev);   
            index = nextIndex;
        }
      
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}