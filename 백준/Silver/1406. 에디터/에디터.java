import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        
        String s = br.readLine();
        
        for(int i=0; i<s.length(); i++) {
            left.push(s.charAt(i));
        }
        
        int M = Integer.parseInt(br.readLine());
        
        for(int i=0; i<M; i++) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            if(command.equals("L")) {
                if(!left.isEmpty()) {
                    right.push(left.pop());
                }
            }
            if(command.equals("D")) {
                if(!right.isEmpty()) {
                    left.push(right.pop());
                }
            }
            if(command.equals("B")) {
                if(!left.isEmpty()) {
                    left.pop();
                }
            }
            if(command.equals("P")) {
                String next = commands[1];
                left.push(next.charAt(0));
            }
        }
        
        while(!left.isEmpty()) {
            right.push(left.pop());
        }
        
        while(!right.isEmpty()) {
            sb.append(right.pop());
        }
        
        System.out.println(sb.toString());
     }
}

