import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int T = Integer.parseInt(st.nextToken());

        for (int i=0; i<T; i++) {
            char[] c = br.readLine().toCharArray();
            boolean isBlank = false;
            stack.clear();

            loop:for(int j=0; j<c.length; j++) {
                if(c[j] == '(') {
                    stack.push(c[j]);
                } else {
                    if(stack.isEmpty()) {
                        sb.append("NO"+"\n");
                        isBlank = true;
                        break loop;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(!isBlank && stack.isEmpty()) {
                sb.append("YES"+"\n");
            } else if(!isBlank && !stack.isEmpty()){
                sb.append("NO"+"\n");
            }
        }
        System.out.println(sb);
    }
}


