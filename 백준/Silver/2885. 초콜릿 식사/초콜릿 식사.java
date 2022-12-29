import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int N = 1;
        int count = 0;
        // 초콜릿 2^N 형태로 만듬
        while(N<K) {
            N = N*2;
        }
        System.out.print(N);
        if(K==N) {
            System.out.print(" "+count);
            return;
        }

        while(K>0) {
            if(K>=N) K-=N;
            else {
                N/=2;
                count++;
            }
        }
        System.out.print(" "+count);
    }

}