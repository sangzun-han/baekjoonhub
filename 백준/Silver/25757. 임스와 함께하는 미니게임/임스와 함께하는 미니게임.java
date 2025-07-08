import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Set<String> set = new HashSet<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String part = st.nextToken();
        
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            set.add(s);
        }
        int answer = 0;
        
        if(part.equals("Y")) {
            answer = set.size();
        }
        else if(part.equals("F")) {
            answer = set.size() / 2;
        }
        else if(part.equals("O")) {
            answer = set.size() / 3;
        }
        
        System.out.println(answer);
    }
}
