import java.io.*;
import java.util.*;

public class Main {
    static class Info implements Comparable<Info>{
        int weight,price;
        Info(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Info o) {
           return this.weight-o.weight;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        Info[] jewel = new Info[N];
        int[] backpack = new int[K];
        int idx = 0;
        long ans = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewel[i] = new Info(m,v);
        }

        for(int i=0; i<K; i++) {
            backpack[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel);
        Arrays.sort(backpack);

        for(int i=0; i<K; i++) {
            while(idx < N && jewel[idx].weight <= backpack[i]) {
                queue.offer(-jewel[idx].price);
                idx++;
            }
            if(!queue.isEmpty()) ans += Math.abs(queue.poll());
        }
        System.out.println(ans);
    }
}