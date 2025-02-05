import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        StringBuilder sb = new StringBuilder();
        
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<record.length ;i++) {
            String rec = record[i];
            String[] recordSplit = rec.split(" ");
            String type = recordSplit[0];
            if(type.equals("Enter") || type.equals("Change")) {
                String uid = recordSplit[1];
                String nickname = recordSplit[2];    
                map.put(uid, nickname);
            }
        }
        
        for(int i=0; i<record.length; i++) {
            String rec = record[i];
            String[] recordSplit = rec.split(" ");
            String type = recordSplit[0];
            String uid = recordSplit[1];
            String nickname = map.get(uid);
            if(type.equals("Enter")) {
                sb.append(nickname).append("님이").append(" ").append("들어왔습니다.");
                list.add(sb.toString());
            } else if(type.equals("Leave")) {
                sb.append(nickname).append("님이").append(" ").append("나갔습니다.");
                list.add(sb.toString());
            }
            sb.setLength(0);
        }
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}