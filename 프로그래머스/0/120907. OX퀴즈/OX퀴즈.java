import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        int size = quiz.length;
        String[] answer = new String[size];
      
        for(int i=0; i<size; i++) {
            String[] sik = quiz[i].split(" ");
         
            int start = Integer.parseInt(sik[0]);
            String mid = sik[1];

            int end = Integer.parseInt(sik[2]);
            String same = sik[3];
            int ans = Integer.parseInt(sik[4]);
            if(mid.equals("-")) {
                if(start - end == ans) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            } else if (mid.equals("+")) {
                 if(start + end == ans) {
                    answer[i] = "O";
                } else {
                    answer[i] = "X";
                }
            }
            
            
        }
        return answer;
    }
}