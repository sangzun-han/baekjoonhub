import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static int[] moloco;
    static int[] other;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        moloco = new int[N];
        other = new int[N];
        int answer = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            moloco[i] = Integer.parseInt(st.nextToken());
            other[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 1_000_000_000;


        while(left <= right){
            int mid = (left+right)/2;

            int k = calc(mid);
            if(K <= k) {
                answer = mid;
                right = mid - 1;
            } else if(K > k){
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static int calc(int mid) {
        int count = 0;
        for(int i=0; i<N; i++) {
            int molocoPrice = moloco[i];
            int otherPrice = other[i];
            if(molocoPrice + mid >= otherPrice) count++;
        }
        return count;
    }
}


