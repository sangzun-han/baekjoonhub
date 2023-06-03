import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int max = 0;
        // 칠할 구역 정렬
        Arrays.sort(section);
       
        for(int i=0; i<section.length; i++) {
            if(section[i]<max) continue;
            else {
                answer++;
                max = section[i] + m;
            }
        }
        
        return answer;
    }
}