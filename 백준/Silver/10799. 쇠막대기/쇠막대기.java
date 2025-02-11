import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                stack.push('(');
            } else if(s.charAt(i)==')'){
                stack.pop();
                // 레이저
                if(s.charAt(i-1)=='(') {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
