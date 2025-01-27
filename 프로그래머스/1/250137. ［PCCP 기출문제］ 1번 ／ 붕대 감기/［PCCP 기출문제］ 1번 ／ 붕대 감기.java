import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Map<Integer, Integer> map = new HashMap<>();

        int 현재체력 = health;
        int 시전시간 = bandage[0];
        int 초당회복량 = bandage[1];
        int 추가회복량 = bandage[2];
        int 성공횟수 = 0;
        
        int lastTime = attacks[attacks.length-1][0];
        
        for(int i=0; i<attacks.length; i++) {
            int attackTime = attacks[i][0];
            int damage = attacks[i][1];
            map.put(attackTime, damage);
        }
        
        for(int time=1; time<=lastTime; time++) {
            // 기술 쓰는 도중 몬스터에게 공격당함
            // 1. 성공횟수 0으로 초기화
            // 2. 데미지 받음
            if(map.containsKey(time)) {
                현재체력 -= map.get(time);
                성공횟수 = 0;
            } else {
                현재체력 += 초당회복량;
                성공횟수++;
                
                if(성공횟수 == 시전시간) {
                    현재체력 += 추가회복량;
                    성공횟수 = 0;
                } 
                
                if(현재체력 >= health) {
                    현재체력 = health;
                }
            }
            
            if(현재체력 <= 0) return -1;
        }
        
        return 현재체력;
    }
}