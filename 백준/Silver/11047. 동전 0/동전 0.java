import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];

        for(int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int start = N-1;

        int cnt = 0 ;
        while(K!=0) {

            if(K/coins[start]>=1) {
                cnt += K/coins[start];
                K = K - (coins[start] * (K/coins[start]));
            } else {
                start--;
            }
        }


        System.out.println(cnt);;
    }
}
