import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] count = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            count[i]++;
        }
        
        for(int i=0; i<lost.length; i++) {
            int num = lost[i];
            count[num]--;
        }
        
        for(int i=0; i<reserve.length; i++) {
            int num = reserve[i];
            count[num]++;
        }
        
      
        for(int i=1; i<=n; i++) {
            // 체육복을 잃어버린 사람 일 때
            if(count[i]==0) {
                if(i-1 >= 1 && count[i-1]==2) {
                    count[i-1]--;
                    answer++;
                } else if(i+1<=n && count[i+1]==2) {
                    count[i+1]--;
                    answer++;
                }
            } else {
                answer++;
            }
            
            
        }
        
        return answer;
    }
}