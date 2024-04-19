import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack();

        int N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer((br.readLine()));

            String s = st.nextToken();

            if(s.equals("push")) {
                int num = Integer.parseInt(st.nextToken());

                stack.push(num);
            }
            else if (s.equals("top")) {
                if(stack.empty()) {
                    sb.append(-1+"\n");
                } else {
                    sb.append(stack.peek()+"\n");
                }
            }
            else if (s.equals("size")) {
                sb.append(stack.size()+"\n");
            }
            else if (s.equals("empty")) {
                if(stack.empty()) {
                    sb.append(1+"\n");
                } else {
                    sb.append(0+"\n");
                }
            }

            else if(s.equals("pop")) {
                if(stack.empty()) {
                    sb.append(-1+"\n");
                } else {
                    sb.append(stack.pop()+"\n");
                }
            }
        }

        System.out.println(sb);


    }
}
