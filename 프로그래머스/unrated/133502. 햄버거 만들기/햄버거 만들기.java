import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<ingredient.length; i++) {
            stack.push(ingredient[i]);
            
            if(stack.size()>=4 && stack.subList(stack.size()-4, stack.size()).equals(List.of(1,2,3,1))) {
                answer++;
                
                for(int j=0; j<4; j++) {
                    stack.pop();
                }
            }
            
            
        }
        return answer;
    }
}