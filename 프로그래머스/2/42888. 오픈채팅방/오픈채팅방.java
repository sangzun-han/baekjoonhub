import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        StringBuilder sb = new StringBuilder();
        List<String> answerList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for(int i=0; i<record.length; i++) {
            String[] s = record[i].split(" ");
            String command = s[0];
            if(command.equals("Enter")) {
                map.put(s[1], s[2]);
            } else if(command.equals("Change")) {
                map.put(s[1], s[2]);
            }
        }
        
        for(int i=0; i<record.length; i++) {
            String[] s = record[i].split(" ");
            String command = s[0];
            String uid = s[1];

            if(command.equals("Enter")) {
                sb
                    .append(map.get(uid))
                    .append("님이 ")
                    .append("들어왔습니다.");
            } else if(command.equals("Leave")) {
                sb
                    .append(map.get(uid))
                    .append("님이 ")
                    .append("나갔습니다.");
            } else {
                continue;
            }
            answerList.add(sb.toString());
            sb.setLength(0);
        }
        
        String[] answer = new String[answerList.size()];
        
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
