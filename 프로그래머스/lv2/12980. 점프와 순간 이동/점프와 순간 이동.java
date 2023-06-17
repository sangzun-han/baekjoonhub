import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int N = n;
        
        while(N!=0) {
            if(N%2==0) {
                N /= 2;
            } else {
                N -= 1;
                ans++;
            }
        }

        

        return ans;
    }
}