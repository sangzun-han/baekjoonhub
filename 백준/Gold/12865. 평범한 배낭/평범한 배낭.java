import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] W = new int[N+1];
        int[] V = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] d = new int[N+1][K+1];
        
        for(int i=1; i<=N ;i++) {
            for(int w=0; w<=K; w++) {
                // i번째 물건을 넣을수없는경우.
                if(w < W[i]) {
                    d[i][w] = d[i-1][w];
                } else {
                    d[i][w] = Math.max(d[i-1][w], d[i-1][w-W[i]] + V[i]);
                }
            }
        }
        
        System.out.println(d[N][K]);        
    }
}
// D[i][j] : i번째 물건까지 봤을때 배넝에 넣은 물건 무게의 합이 j 일때 최대값
// N 물품의 수, K 버틸수 있는 무게
