import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;
        HashMap<String, Integer> wantList = new HashMap<>();
        HashMap<String, Integer> buyList = new HashMap<>();
        
        for(int i=0; i<want.length; i++) {
            wantList.put(want[i], number[i]);
        }
        
        for(int i=0; i<discount.length - 9; i++) {
            for(int j=0; j<10; j++) {
                buyList.put(discount[i+j], buyList.getOrDefault(discount[i+j],0) + 1);   
            }
            
            boolean flag = true;
            for(String product: wantList.keySet()) {    
                if(wantList.get(product) != buyList.get(product)) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
            buyList.clear();
        }
        
        return answer;
    }
}