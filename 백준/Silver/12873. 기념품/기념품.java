import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long num = 1;
        Queue<Integer> queue = new ArrayDeque<>();

        // 사람 1부터~N까지
        for(int i=1; i<=N; i++) {
            queue.offer(i);
        }

        while(queue.size()!=1) {
            // 반복은 사람의 횟수^3만큼 돌 필요 없음 횟수^3만큼 돌시 시간초과
            long repeat = (num*num*num-1)%queue.size();

            for(int i=0; i<repeat; i++) {
                int person = queue.poll();
                queue.offer(person);
            }
            num++;
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}