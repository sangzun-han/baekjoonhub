import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int answerOne = 0;
        int answerTwo = 0;
        int answerThree = 0;
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i]==one[i%one.length]) answerOne++;
            if(answers[i]==two[i%two.length]) answerTwo++;
            if(answers[i]==three[i%three.length]) answerThree++;
        }
        
        
        int max = Math.max(answerOne, Math.max(answerTwo, answerThree));

        List<Integer> list = new ArrayList<>();
        if (answerOne == max) list.add(1);
        if (answerTwo == max) list.add(2);
        if (answerThree == max) list.add(3);

        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        

        return answer;
    }
}