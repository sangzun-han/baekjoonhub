import java.util.*;

class Solution {
    static char[] operation = {'*','+','-'};
    static boolean[] selected = new boolean[3];
    static long answer;
    public long solution(String expression) {
        answer = 0;
        perm(expression, 0, new ArrayList<>());    
        
        return answer;
    }
    
    public void perm(String expression, int size, List<Character> operationOrder) {
        if(size==3) {
            // 우선순위 만들었으니 expression계산
            answer = Math.max(calc(expression, operationOrder), answer);
            return;
        }
        
        for(int i=0; i<operation.length; i++) {
            if(!selected[i]) {
                selected[i] = true;
                operationOrder.add(operation[i]);
                perm(expression, size+1, operationOrder);
                selected[i] = false;
                operationOrder.remove(operationOrder.size() - 1);
            }
        }
    }
    
    public long calc(String expression, List<Character> operationOrder) {
        List<Character> op = new ArrayList<>();
        List<Long> number = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(char exp: expression.toCharArray()) {
            if(exp=='*' || exp=='+' || exp=='-') {
                op.add(exp);
                number.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
            } else {
                sb.append(exp);
            }
        }
        number.add(Long.parseLong(sb.toString()));
        
        for(char operator: operationOrder) {
            for(int i=0; i<op.size(); i++) {
                if(op.get(i)==operator) {
                    long prev = number.get(i);
                    long next = number.get(i+1);
                    long result = 0;
                    
                    if(operator=='*') result = prev * next;
                    else if (operator=='+') result = prev + next;
                    else if (operator=='-') result = prev - next;
                    
                    number.set(i,result);
                    number.remove(i+1);
                    op.remove(i);
                    i--;
                }
            }
        }
        return Math.abs(number.get(0));
    }
}

