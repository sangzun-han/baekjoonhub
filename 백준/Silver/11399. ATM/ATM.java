import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] times = new int[N];
        int[] ans = new int[N];
        int sum = 0;
        int answer = 0;
        for(int i=0; i<N; i++) {
            int P = Integer.parseInt(st.nextToken());
            times[i] = P;

        }

        Arrays.sort(times);


        for(int i=0; i<N;i ++) {
            sum += times[i];
            ans[i] = sum;
        }

        for(int i=0; i<N; i++) {
            answer += ans[i];
        }

        System.out.println(answer);





    }
}

