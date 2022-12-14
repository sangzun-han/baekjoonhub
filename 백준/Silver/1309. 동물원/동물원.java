import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N+1][3];
        int mod = 9901;
        d[0][0] = 1;
        d[0][1] = 1;
        d[0][2] = 1;

        for(int i=1; i<N; i++) {
            for(int j=0; j<3; j++) {
                if(j==0) {
                    d[i][j] = d[i-1][0]%mod + d[i-1][1]%mod + d[i-1][2]%mod;
                } else if(j==1) {
                    d[i][j] = d[i-1][0]%mod + d[i-1][2]%mod;
                } else if(j==2) {
                    d[i][j] = d[i-1][0]%mod + d[i-1][1]%mod;
                }
            }
        }

        System.out.println((d[N-1][0]+d[N-1][1]+d[N-1][2])%mod);
    }
}