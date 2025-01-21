import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 선물 지수 구하기 위한 자료구조
        HashMap<String, Integer> giveHm = new HashMap<>();
        HashMap<String, Integer> takeHm = new HashMap<>();
       
        // 선물 기록 구하기 위한 자료구조
        HashMap<String, HashMap<String, Integer>> giftRecord = new HashMap<>();
        
        for(int i=0; i<gifts.length; i++) {
            String[] s = gifts[i].split(" ");
            String givePeople = s[0];
            String takePeople = s[1];
            
            giveHm.put(givePeople, giveHm.getOrDefault(givePeople, 0) + 1);
            takeHm.put(takePeople, takeHm.getOrDefault(takePeople, 0) + 1);
            
            HashMap<String, Integer> inner = giftRecord.getOrDefault(givePeople, new HashMap<>());
            inner.put(takePeople, inner.getOrDefault(takePeople, 0) + 1);
            giftRecord.put(givePeople, inner);
        }
        
        // 선물 지수 계산을 위한 자료구조
        HashMap<String, Integer> giftIndexHm = new HashMap<>();
        for(String friend: friends) {
            Integer giveCount = giveHm.getOrDefault(friend, 0);
            Integer takeCount = takeHm.getOrDefault(friend, 0);
            
            Integer index = giveCount - takeCount;
            giftIndexHm.put(friend, index);
        }
        
        // 다음달에 받게 될 선물 갯수
        HashMap<String, Integer> receiveCount = new HashMap<>();
        
        // 친구별로 규칙 적용하기
        int n = friends.length;
        
        for(int i=0; i<n; i++) {
            String friendA = friends[i];
            for(int j=i+1; j<n; j++) {
                String friendB = friends[j];
                
                int AB = 0;
                int BA = 0;
                // 서로 선물을 준 기록 확인
                if(giftRecord.containsKey(friendA)) {
                    AB = giftRecord.get(friendA).getOrDefault(friendB, 0);
                }
                 if(giftRecord.containsKey(friendB)) {
                    BA = giftRecord.get(friendB).getOrDefault(friendA, 0);
                }
                
                if(AB != 0 || BA != 0) {
                    if(AB > BA) {
                        receiveCount.put(friendA, receiveCount.getOrDefault(friendA, 0) + 1);
                    } else if (AB < BA) {
                        receiveCount.put(friendB, receiveCount.getOrDefault(friendB, 0) + 1);
                    } else {
                        // 같다면 선물지수로 판단
                        int giftIndexA = giftIndexHm.get(friendA);
                        int giftIndexB = giftIndexHm.get(friendB);
                        
                        if(giftIndexA > giftIndexB) {
                            receiveCount.put(friendA, receiveCount.getOrDefault(friendA, 0) + 1);
                        } else if (giftIndexA < giftIndexB) {
                            receiveCount.put(friendB, receiveCount.getOrDefault(friendB, 0) + 1);
                        }
                    }
                } else {
                    int giftIndexA = giftIndexHm.getOrDefault(friendA, 0);
                    int giftIndexB = giftIndexHm.getOrDefault(friendB, 0);
                        
                    if(giftIndexA > giftIndexB) {
                        receiveCount.put(friendA, receiveCount.getOrDefault(friendA, 0) + 1);
                    } else if (giftIndexA < giftIndexB) {
                        receiveCount.put(friendB, receiveCount.getOrDefault(friendB, 0) + 1);
                    }
                }
            }
        }
        
        for(String friend: friends) {
            answer = Math.max(answer, receiveCount.getOrDefault(friend, 0));
        }
        
        
        return answer;
    }
}