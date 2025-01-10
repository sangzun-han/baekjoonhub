import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        if(기울기(dots[0], dots[1]) == 기울기(dots[2], dots[3])) return 1;
        if(기울기(dots[0], dots[2]) == 기울기(dots[1], dots[3])) return 1;
        if(기울기(dots[0], dots[3]) == 기울기(dots[1], dots[2])) return 1;
        
        return 0;
    }
    
    private double 기울기(int[] dot1, int[] dot2) {
        return (double)(dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }
}