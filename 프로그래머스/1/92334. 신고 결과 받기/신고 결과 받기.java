import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고한 사람 -> 신고한 사람 리스트(중복방지)
        Map<String, Set<String>> userReports = new HashMap<>();
        // 신고받은 사람 -> 신고 횟수
        Map<String, Integer> reportedCount = new HashMap<>();
            
        // 유저 초기화
        for(String user: id_list) {
            userReports.put(user, new HashSet<>());
            reportedCount.put(user, 0);
        }
        
        // 신고 기록 처리
        for(String rep: report) {
            String[] s = rep.split(" ");
            String reporter = s[0]; // 신고한사람
            String reported = s[1]; // 신고 받은 사람
            
            if(userReports.get(reporter).add(reported)) {
                reportedCount.put(reported, reportedCount.get(reported) + 1);
            }
        }
        
        // 정지된사람 목록 찾기
        Set<String> banUsers = new HashSet<>();
        
        for(Map.Entry<String, Integer> user: reportedCount.entrySet()) {
                if(user.getValue() >= k) {
                    banUsers.add(user.getKey());
                }
        }
        
        // 메일 발송 계산
        int[] answer = new int[id_list.length];
        
        for(int i=0; i<id_list.length; i++) {
            String user = id_list[i];
            int count = 0;
            
            for(String reported: userReports.get(user)) {
                if(banUsers.contains(reported)) {
                    count++;
                }
            }
            answer[i] = count;
        }
        
        
        
        
        return answer;
    }
}