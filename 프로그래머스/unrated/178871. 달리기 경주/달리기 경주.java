import java.util.*;
import java.io.*;

class Solution {
    String[] Players = {};
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String,Integer> mapPlayer = new HashMap<>();
        HashMap<Integer,String> mapRank = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            mapPlayer.put(players[i],i);
            mapRank.put(i, players[i]);
        }
        
        for(int i=0; i<callings.length; i++) {
            // callings[i] 플레이어 순위
            int rank = mapPlayer.get(callings[i]);
            // 플레이어 이름
            String name = mapRank.get(rank);
            
            // 이전 플레이어 이름
            String backName = mapRank.get(rank-1);
            
            mapPlayer.put(name, rank-1);
            mapPlayer.put(backName, rank);
            
            mapRank.put(rank-1,name);
            mapRank.put(rank,backName);
            
        }
        
       for(int i=0; i<players.length; i++) {
           answer[i] = mapRank.get(i);
       }
        return answer;
    }
}