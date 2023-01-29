import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] length = new long[N];
        long max = 0;
        for(int i=0; i<N; i++) {
            length[i] = Integer.parseInt(br.readLine());
            if(max < length[i]) max = length[i];
        }

        long min = 0;
        long mid = 0;

        max++;
        while(min < max) {
            int cnt = 0;
            mid = (min+max) / 2;

            for(int i=0; i<N; i++) {
                cnt += (length[i] / mid);
            }

            if(cnt < K) {
                max = mid;
            } else {
                min = mid+1;
            }
        }

        System.out.println(min-1);
    }
}