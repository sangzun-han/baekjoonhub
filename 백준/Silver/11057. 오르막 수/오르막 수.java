import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N+1][10];
        int mod = 10007;
        for(int i=0; i<=9; i++) d[1][i] = 1;
        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                for(int k=0; k<=j; k++) {
                    d[i][j] += d[i-1][k];
                    d[i][j] %= mod;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<=9; i++) {
            ans += d[N][i];
            ans %= mod;
        }
        System.out.println(ans%mod);
    }
}