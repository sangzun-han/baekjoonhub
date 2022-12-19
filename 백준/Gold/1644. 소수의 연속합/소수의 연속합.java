import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        // false면 소수
        boolean[] isPrime = new boolean[N+1];
        isPrime[0] = true; isPrime[1] = true;
        for(int i=2; i*i<=N; i++) {
            if(!isPrime[i]) {
                for(int j=i*2; j<=N; j+=i) {
                    isPrime[j] = true;
                }
            }
        }


        ArrayList<Integer> prime = new ArrayList<>();
        for(int i=2; i<=N; i++) {
            if(!isPrime[i]) prime.add(i);
        }

        // 투포인터를 이용해 부분합 구하기
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;
        while(true) {
            if(sum>=N) sum -= prime.get(left++);
            else if (right==prime.size()) break;
            else if (sum < N ) sum += prime.get(right++);
            if(sum==N) ans++;
        }
        System.out.println(ans);
    }
}