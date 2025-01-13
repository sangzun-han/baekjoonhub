import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int oneCount = 0;
        char[] binaryNumber = String.valueOf(Integer.toBinaryString(n)).toCharArray();
        
        for(int i=0; i<binaryNumber.length; i++) {
            if(binaryNumber[i]=='1') oneCount++;
        }
        
        answer = calc(n, oneCount);
        return answer;
    }
    
    public int calc(int n, int count) {
        
        for(int i=n+1; i<=1000000; i++) {
            int oneCount = 0;
            char[] binaryNumber = String.valueOf(Integer.toBinaryString(i)).toCharArray();
            
            for(int j=0; j<binaryNumber.length; j++) {
                if(binaryNumber[j]=='1') oneCount++;
            }
            
            if(oneCount == count) return i;
        }
        
        return 0;
    }
    
    

    
}