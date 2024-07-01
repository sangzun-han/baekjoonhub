import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
    
        if(arr.length==1) {
           return new int[] {-1};
        }
        
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0; i<arr.length; i++) {
               if(min > arr[i]) {
                   min = arr[i];
                   index = i;
               }         
        }
        
        int[] answer = new int[arr.length-1];
        int j = 0;
        for(int i=0; i<arr.length; i++) {
            if(i!=index) {
                answer[j++] = arr[i];         
            }
       
        }
        
         
        return answer;
    }
}