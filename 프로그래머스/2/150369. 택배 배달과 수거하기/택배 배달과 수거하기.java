import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long dRemain = 0;
        long pRemain = 0;
        
        // 가장 먼곳부터 처리하는게 최적의 해일듯
        for(int i=n-1; i>=0; i--) {
            
            dRemain += deliveries[i];
            pRemain += pickups[i];
            
            if(dRemain <= 0 && pRemain <=0) continue;
            
            // 한번 이동시 배달,수거 동시에 한다.
            int repeat = Math.max(
                (int) Math.ceil((double) dRemain / cap),
                (int) Math.ceil((double) pRemain / cap)
            );
            // i는 거리 그런데 0부터시작하니까 + 1
            // 왕복 * 2
            // cap만큼 실을수있으니 그만큼 반복
            answer += (i+1) * 2 * repeat;
            
            // 남은거에서 최대갯수 * 반복만큼 배달,수거를 수행함
            // -가 되도 상관없음 다음 반복에서 -라는것은 이미 배달,수거를 완료했다는 뜻.
            dRemain -= cap * repeat;
            pRemain -= cap * repeat;
            
        }
        return answer;
    }
}