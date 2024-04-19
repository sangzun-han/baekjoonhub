import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();

        sb.append("<");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) {
            queue1.offer(i);
        }

        while(!queue1.isEmpty()) {
            for(int i=1; i<K; i++) {
                int a = queue1.poll();
                queue1.offer(a);
            }
            int b = queue1.poll();
            queue2.offer(b);
        }

        while(!queue2.isEmpty()) {
            sb.append(queue2.poll()+", ");
        }
        sb.delete(sb.length()-2, sb.length()-0);

        sb.append(">");

        System.out.println(sb);


    }
}
