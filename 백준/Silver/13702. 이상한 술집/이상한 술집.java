import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ml = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
            ml[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,ml[i]);
        }


        long left = 1;
        long right = max;
        long ans = 0;
        while(left <= right) {
            long mid = (left+right)/2;
            int count = 0;

            for(int i=0; i<N; i++) {
                count += (ml[i]/mid);
            }

            if(count >= K) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}


