import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static List<String> answerList = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        for(int i=0; i<course.length; i++) {
            for(int j=0; j<orders.length; j++) {
                char[] c = orders[j].toCharArray();
                Arrays.sort(c);
                comb("", c, course[i], 0);
            }
            
            int max = 0;
            for(String key: map.keySet()) {
                int count = map.get(key);
                if(count < 2) continue;
                max = Math.max(max, count);
            }
            
            for(String key: map.keySet()) {
                if(map.get(key)==max) {
                    answerList.add(key);
                }
            }
        
            map.clear();
        }
        
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public void comb(String cur, char[] order, int course, int index) {
        if(order.length < course) return;
        
        if(cur.length()==course) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }
        
        for(int i=index; i<order.length; i++) {
            comb(cur + order[i], order, course, i+1);
        }
    }
    
    
}

// 가장 많이 주문한 메뉴를 코스로 구성한다. 메뉴는 최소 2가지 이상, 2명이상 손님으로부터 주문된 가장많은??
// orders에서 cours에 나온 숫자만큼 모든 조합을 만든다.  2^10 * 20 * 10
