import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int n: arr) {
            list.add(n);
        }
        
        for(int i=0; i<query.length; i++) {
            int size = list.size();
            if(i%2==0) {
                list = new ArrayList<>(list.subList(0, query[i]+1));
            }
            else {
                list = new ArrayList<>(list.subList(query[i], size));
            }
        }
        
        int[] answer = new int[list.size()];
       
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}