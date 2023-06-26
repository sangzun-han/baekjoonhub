import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 사야될 물건과 개수
        HashMap<String,Integer> wantList = new HashMap<>();
        // x ~ x+10일간 사게될 물건과 개수
        HashMap<String,Integer> buyList = new HashMap<>();
        
        for(int i=0; i<want.length; i++) {
            wantList.put(want[i], number[i]);
        }
        
        
        for(int i=0; i<discount.length-9; i++) {
            buyList.clear();
            for(int j=0; j<10; j++) {
                buyList.put(discount[i+j], buyList.getOrDefault(discount[i+j],0)+1);
            }
            
            boolean flag = true;
            
            for(String buyItem: buyList.keySet()) {
                if(wantList.get(buyItem) != buyList.get(buyItem)) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
}