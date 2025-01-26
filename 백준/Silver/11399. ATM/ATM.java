import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        int[] ans = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());

        int answer = 0;
        for(int i=0; i<N; i++)  {
            int num = Integer.parseInt(st.nextToken());
            times[i] = num;
        }

        Arrays.sort(times);

        for(int i=0; i<N; i++) {
            sum += times[i];
            ans[i] = sum;
        }

        for(int i=0; i<N; i++) {
            answer += ans[i];
        }

        System.out.println(answer);
    }
}

