import java.util.*;

class Solution {
    public int[] solution(String s) {
        char[] arr = s.toCharArray();
        int size = arr.length;
        int[] answer = new int[size];
        HashMap<Character, Integer> hashmap = new HashMap<>();
        
        for(int i=0; i<size; i++) {
            if(!hashmap.containsKey(arr[i])) {
                answer[i] = -1;
                hashmap.put(arr[i],i);
            }  else {
                answer[i] = i - hashmap.get(arr[i]);
                hashmap.put(arr[i],i);
            }
        }
        return answer;
    }
}