import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> listen = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            listen.put(s,1);
        }



        for(int i=0; i<M; i++) {
            String s = br.readLine();
            if(listen.containsKey(s)) {
                list.add(s);

            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for(String s: list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
