import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       
        ArrayList<Integer> list = new ArrayList<>();
        int size = arr.length;
        int index = 0;
       
        while(index < size) {
            list.add(arr[index]);
            while(index < size-1 && arr[index]== arr[index+1]) {
                index++;
            }
            index++;
        }
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}