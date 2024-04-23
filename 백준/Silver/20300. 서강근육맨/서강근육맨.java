import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] M = new long[N];

        st= new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            M[i] = Long.parseLong(st.nextToken());
        }


        Arrays.sort(M);
        long ans = Long.MIN_VALUE;

        if(N%2==1) {
            for(int i=0; i<N/2; i++) {
                long sum = M[i] + M[N-2-i];
                ans = Math.max(sum,ans);
            }
        } else {
            for(int i=0; i<N/2; i++) {
                long sum = M[i] + M[N-1-i];
                ans = Math.max(sum,ans);
            }
        }


        System.out.println(ans);

    }
}
