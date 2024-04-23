import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] primes = new boolean[N+1];

        primes[0] = true;
        primes[1] = true;

        for(int i=2; i*i<N+1; i++) {
            if(!primes[i]) {
                for(int j=i*i; j<N+1; j+=i) {

                    primes[j] = true;
                }
            }
        }


        int min = 999999;
        int sum = 0;
        for(int i=M; i<=N; i++) {
            // 소수면
            if(!primes[i]) {
                min = Math.min(i,min);
                sum += i;
            }
        }

        if(min==999999) {
            System.out.println(-1);
            return;
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
