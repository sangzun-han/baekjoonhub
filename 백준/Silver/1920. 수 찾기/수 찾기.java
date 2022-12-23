import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            map.put(Integer.parseInt(st.nextToken()),1);
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            if(map.containsKey(B[i])) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}