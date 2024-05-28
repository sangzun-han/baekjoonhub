import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] % divisor==0) {
                list.add(arr[i]);
            }
        }
        Collections.sort(list);
        int size = list.size() > 0 ? list.size() : 1;
        int[] answer = new int[size];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
    
        if(list.size()==0) {
            answer[0] = -1;
            return answer;
        } else {
            return answer;    
        }
        
    }
}