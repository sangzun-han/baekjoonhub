import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(n, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
