import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        ArrayList<Integer> primes = new ArrayList<>();
        int limit = (int) Math.sqrt(B);
        boolean[] isPrime = new boolean[limit+1];
        Arrays.fill(isPrime, true);

        //isPrime = true면 소수

        for(int i=2; i<=limit; i++) {
            if(isPrime[i]) {
                primes.add(i);
                for(long j=(long)i*i; j<=limit; j+=i) {
                    isPrime[(int) j] = false;
                }
            }
        }

        int count = 0;

        for(int prime: primes) {
            long num = (long) prime * prime;
            while(num <= B) {
                if(num >= A) {
                    count++;
                }
                if(B/num < prime) break;
                // n제곱근꼴
                num = num * prime;
            }
        }

        System.out.println(count);




    }
}
