import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] s = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(s);

        System.out.println(s[s.length-1] + s.length - 1);
    }
}

    