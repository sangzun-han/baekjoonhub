import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] land = new int[M][N];
        int[][] dp = new int[M][N];
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<M; i++) {
            if(land[i][0] != 0) dp[i][0] = -1;
            else dp[i][0] = 1;
        }
        
        for(int i=0; i<N; i++) {
            if(land[0][i] != 0) dp[0][i] = -1;
            else dp[0][i] = 1;
        }
        
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(land[i][j] > 0) dp[i][j] = -1;
            }
        }
        
        for(int i=1; i<M; i++) {
            for(int j=1; j<N; j++) {
                if(dp[i][j] == -1) continue;
                
                if(dp[i-1][j] > 0 && dp[i][j-1] > 0 && dp[i-1][j-1] > 0) {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                } else {
                    dp[i][j] = 1;
                }
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                // System.out.print(dp[i][j]+" ");
                answer = Math.max(answer, dp[i][j]);
            }
            // System.out.println();
        }
       
        System.out.println(answer);
    }
}


