import java.util.*;

class Price {
    int index;
    int price;
    
    public Price(int index, int price) {
        this.index = index;
        this.price = price;
    }
}

class Solution {
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Price> stack = new Stack<>();
        
        for(int i=prices.length-1; i>=0; i--) {
            
            while(!stack.isEmpty() && stack.peek().price >= prices[i]) {
                stack.pop();
            }
            
            if(stack.isEmpty()) {
                answer[i] = prices.length - i - 1;
            } else {
                answer[i] = stack.peek().index - i;
            }
            
            stack.push(new Price(i, prices[i]));
        }
        
        return answer;
    }
}