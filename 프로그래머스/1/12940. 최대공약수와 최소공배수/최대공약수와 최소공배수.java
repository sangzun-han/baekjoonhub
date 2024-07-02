import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        int gcbNum = gcb(max, min);
        int lcmNum = n*m/gcbNum;
        answer[0] = gcbNum;
        answer[1] = lcmNum;
        return answer;
    }
    
    private static int gcb(int x, int y) {
        int r = 0;
        while(y!=0) {
            r = x%y;
            x = y;
            y = r;
        }
        return x;
    }
}
    