import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletMin = Math.min(wallet[0],wallet[1]);
        int walletMax = Math.max(wallet[0],wallet[1]);
        int billMin = Math.min(bill[0], bill[1]);
        int billMax = Math.max(bill[0], bill[1]);
        
        while(billMin > walletMin || billMax > walletMax) {
            billMax = billMax / 2;
            if(billMax < billMin) {
                int temp = billMax;
                billMax = billMin;
                billMin = temp;
            }
            answer++;
        }
        
        return answer;
    }
}