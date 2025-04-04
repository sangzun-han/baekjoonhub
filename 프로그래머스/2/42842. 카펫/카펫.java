// 넓이는 brown + yellow
// 해당 넓이에 해당하는 brown,yellow 순서쌍을 구해야함
// 순서쌍을 구해서 1,12 2,6 3,4
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;
        
        int b = 0; 
        
        for(int y=1; y<=(int)Math.ceil(Math.sqrt(area)); y++) {
            if((area%y)==0) {
                b = area / y;
                
                // 위 과정을 통해 모든 순서쌍 찾음
                // 찾은 순서쌍 brown개수를 연산해서 brown과 일치하도록 찾는다.
                if((b*2) + (y-2)*2 == brown) {
                    answer[0] = Math.max(b,y);
                    answer[1] = Math.min(b,y);
                }
            }            
           
         
        }
        
        return answer;
    }
}
    