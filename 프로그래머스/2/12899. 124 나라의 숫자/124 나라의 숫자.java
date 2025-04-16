import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> stack = new Stack<>();
        
        while(n!=0) {
            int remain = n % 3;
            if(remain != 0) {
                stack.push(remain);
                n /= 3;
            } else if(remain == 0) {
                stack.push(4);
                n = (n / 3) - 1;
            }
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
}

// 3진법
// 1 % 3 = 1
// 2 % 3 = 2;
// 3 % 3 = 0 -> 4

// 4 % 3 = 1 -> 1 % 3 = 1 , 11
// 5 %3 = 2 -> 2  1 % 3 = 1
// 6 % 3 = 0 -> 4  2 % 3 =  2  24
// 7 % 3 = 1 2 % 3 = 2  21
// 8 % 3 = 2 2 % 3 = 2 22
// 9 % 3 = 0 -> 4 2 % 3 = 0 

// %3 == 0 이라면 다음 나눌때 /3 -1을 한다. 이유는 모름 그런규칙인데?
