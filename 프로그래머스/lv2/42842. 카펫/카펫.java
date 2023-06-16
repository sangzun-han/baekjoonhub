import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=1; i*i<=sum; i++) {
            if(sum%i==0) {
                list.add(i);
                list.add(sum/i);
            }
        }
        
        Collections.sort(list);
        
        for(int i=0; i<list.size(); i++) {
            int width = list.get(i);
            int height = list.get(list.size()-i-1);
            
            if((width-2)*(height-2)==yellow) {
                answer[0] = height;
                answer[1] = width;
                break;
            }
        }
        
        return answer;
    }
}