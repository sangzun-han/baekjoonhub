import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int order = 0;
        int number = 0;
        int[] answer = new int[2];
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            
            int count = map.getOrDefault(word, 0);
            if(count==1) {
                number = (i%n)+1;
                order = (i/n)+1;
                answer[0] = number;
                answer[1] = order;
                return answer;                
            }

            if(i-1>=0) {
                String prev = words[i-1];
                if(word.charAt(0) != prev.charAt(prev.length()-1)) {
                    number = (i%n)+1;
                    order = (i/n)+1;
                    answer[0] = number;
                    answer[1] = order;
                    return answer;
                }
            }

            map.put(word, 1);
            
        }

        return answer;
    }
}


// 1.반복을 돌면서
// 1-1) 시작한 끝자리랑 다음거랑 일치하는지 체크 else
// 1-2) 동일한 단어를 말했는지 체크