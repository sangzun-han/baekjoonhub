import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N+1];

        for(int i=1; i<=N ;i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int i=0; i<M; i++) {
            int target = deque.indexOf(nums[i]);
            int half;

            if(deque.size()%2==0) {
                half = deque.size()/2-1;
             } else {
                half = deque.size() / 2;
            }

            // 중간지점보다 앞에 있다면 2번연산 시행,
            if(target <= half) {
                for(int j=0; j<target; j++) {
                    int x = deque.pollFirst();
                    deque.offerLast(x);
                    count++;
                }
            } else {
                for(int j=0; j<deque.size()-target; j++) {
                    int x = deque.pollLast();
                    deque.offerFirst(x);
                    count++;
                }
            }
            deque.pollFirst();
        }


        System.out.println(count);

    }
}


