import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> A = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // key : 숫자, value: 처음 등장한 위치

        for(int i=0; i<N; i++) {
            A.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(A);

        for(int i=0; i<N; i++) {
            int num = A.get(i);
            if(map.containsKey(num)) continue;
            map.put(num, i);
        }


        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(br.readLine());
            if(map.get(num)==null) {
                sb.append(-1).append("\n");
            } else {
                sb.append(map.get(num)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
