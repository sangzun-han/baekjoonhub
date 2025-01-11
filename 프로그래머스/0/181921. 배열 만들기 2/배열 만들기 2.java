import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int num=l; num<=r; num++) {
            if(isValid(num))  {
                list.add(num);
            }
        }
        
        if(list.size() == 0) {
            return new int[]{-1};
        }
        
        int size = list.size();    
        int[] answer = new int[size];
        
        
        for(int i=0; i<size; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    
    private boolean isValid(int num) {
        String s = String.valueOf(num);
        for(char c: s.toCharArray()) {
            if(c != '0' && c != '5') {
                return false;
            }
        }
        
        return true;
    }
}