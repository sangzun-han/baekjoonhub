import java.util.*;

class Solution {
    static boolean[] visited = new boolean[3];
    static List<String> op = new ArrayList<>();
    static long max = -1;
    
    public long solution(String expression) {
        String[] operators = {"*","+","-"};
        // 연산자 우선순위 정하기 (6가지)
        perm(operators, 0, expression);
        return max;
    }
    
    public void perm(String[] operators, int count, String expression) {
        if(count==3) {
            calc(expression);
            return;
        }
        
        for(int i=0; i<operators.length; i++) {
            if(!visited[i]) {
                op.add(operators[i]);
                visited[i] = true;
                perm(operators, count+1, expression);
                visited[i] = false;
                op.remove(op.size() -1);
            }
        }
    }
    
    public long calc(String expression) {
        List<Long> nums = new ArrayList<>();
        List<String> ops = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                nums.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                ops.add(String.valueOf(ch));
            } else {
                sb.append(ch);
            }
        }
        nums.add(Long.parseLong(sb.toString()));

        // 우선순위 순서대로 연산 처리
        for (String currentOp : op) {
            for (int i = 0; i < ops.size(); ) {
                if (ops.get(i).equals(currentOp)) {
                    long a = nums.get(i);
                    long b = nums.get(i + 1);
                    long result = operate(a, b, currentOp);

                    nums.remove(i + 1);
                    nums.set(i, result);
                    ops.remove(i);
                } else {
                    i++;
                }
            }
        }

        long result = Math.abs(nums.get(0));
        max = Math.max(max, result);
        return result;
    }
    
    public long operate(long a, long b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
        }
        return 0;
    }
}