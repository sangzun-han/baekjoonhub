import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        String[] personalType = {"RT", "CF", "JM", "AN"};
        Map<String, Integer> peopleScore = new HashMap<>();
        Map<Integer, Integer> choiceScore = new HashMap<>();
        choiceScore.put(7,3);
        choiceScore.put(6,2);
        choiceScore.put(5,1);
        choiceScore.put(4,0);
        choiceScore.put(3,1);
        choiceScore.put(2,2);
        choiceScore.put(1,3);
        
        for(int i=0; i<survey.length; i++) {
            String[] sur = survey[i].split("");
            String first = sur[0];
            String second = sur[1];
            int choice = choices[i];
            int score = choiceScore.get(choice);
            if(choice < 4) {
                peopleScore.put(first, peopleScore.getOrDefault(first, 0) + score);
            } else if (choice > 4) {
                peopleScore.put(second, peopleScore.getOrDefault(second, 0) + score);
            }
        }
        
        for(int i=0; i<personalType.length; i++) {
            String[] type = String.valueOf(personalType[i]).split("");
            // 순서대로 성격유형만들기
            String first = type[0];
            String second = type[1];
            
            int firstScore = peopleScore.getOrDefault(first, 0);
            int secondScore = peopleScore.getOrDefault(second, 0);
            
            if(firstScore >= secondScore) {
                sb.append(first);
            } else {
                sb.append(second);
            }
        }
        
        return sb.toString();
    }
}