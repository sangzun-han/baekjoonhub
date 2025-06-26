import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] d = new int[101]; // d[i] = i까지 왔을때 주사위를 던진 최소 횟수
        int[] next = new int[101]; // next[i]: i까지 왔을때 사다리,뱀으로 갈수있는 위치
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            next[x] = y;
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            next[x] = y;
        }
        
        queue.offer(1);
        
        while(!queue.isEmpty()) {
            int n = queue.poll();
            
            for(int i=1; i<=6; i++) {
                int y = n + i;
                if(y > 100) continue;
                if(next[y] != 0) y = next[y];
                if (d[y]==0) {
                    d[y] = d[n] + 1;
                    queue.offer(y);
                }
            }
        }
        System.out.println(d[100]);
        
    }
}