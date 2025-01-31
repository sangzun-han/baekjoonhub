import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String, Integer> playerToRanking = new HashMap<>();
        Map<Integer, String> rankingToPlayer = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            int ranking = i;
            String player = players[i];
            
            playerToRanking.put(player, ranking);
            rankingToPlayer.put(ranking, player);
        }
        
        for(int i=0; i<callings.length; i++) {
            // 추월한 선수 이름과 순위
            String calledPlayer = callings[i];
            int currentRanking = playerToRanking.get(calledPlayer);
            // 추월당한 선수 이름과 순위
            String prevPlayer = rankingToPlayer.get(currentRanking-1);
            int prevPlayerRank = playerToRanking.get(prevPlayer);
            // 이름 불린 선수의 순위는 올리고, 추월당한 선수는 순위 내려간다.

            playerToRanking.put(calledPlayer, currentRanking-1);
            rankingToPlayer.put(currentRanking-1, calledPlayer);
            
            playerToRanking.put(prevPlayer, prevPlayerRank+1);
            rankingToPlayer.put(prevPlayerRank+1, prevPlayer);
        }
        
        for(int i=0; i<players.length; i++) {
            answer[i] = rankingToPlayer.get(i);
        }
      
        
        return answer;
    }
}