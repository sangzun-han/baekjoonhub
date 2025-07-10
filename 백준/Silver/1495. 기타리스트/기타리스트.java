import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] v = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[][] d = new boolean[N+1][M+1];
        // d[i][j] : i번째곡 까지 연주했을때 볼륨 j로 가능한가?
        d[0][S] = true;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<=M; j++) {
                if(d[i][j]) {
                    if(j + v[i] <= M) d[i+1][j+v[i]] = true;
                    if(j - v[i] >= 0) d[i+1][j-v[i]] = true;     
                }
               
            }
        }
        
        int result = -1;
        for(int i=M; i>=0; i--) {
            if(d[N][i]) {
                result = i;
                break;
            }
        }
        
        System.out.println(result);
        
    }
}
