import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int answer = 0;
        int curHealth = health;
        int castingTime = bandage[0];
        int perRecovery = bandage[1];
        int plusRecovery = bandage[2];
        int successTime = 0;
            
        int maxTime = attacks[attacks.length - 1][0];
        for(int i=0; i<attacks.length; i++) {
            int key = attacks[i][0];
            int value = attacks[i][1];
            map.put(key,value);
        }
        

        for(int time=1; time<=maxTime; time++) {
            if(map.containsKey(time)) {
                curHealth -= map.get(time);
                successTime = 0;
            } else {
                curHealth += perRecovery;
                successTime++;
                
                if(successTime == castingTime) {
                    curHealth += plusRecovery;
                    successTime = 0;
                }
                
                if(curHealth > health) {
                    curHealth = health;
                }
            }
            
            if(curHealth <= 0) return -1;
        }
        
        return curHealth;
    }
}