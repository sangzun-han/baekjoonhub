import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] S;
    static boolean[] selected;
    static boolean[] check = new boolean[2000001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        selected = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        subset(0,0);

        for(int i=1; i<2000001; i++) {
            if(!check[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    private static void subset(int sum, int cnt) {
        if(cnt==N) {
            check[sum] = true;
            return;
        }
        subset(sum+S[cnt], cnt+1);
        subset(sum, cnt+1);
    }
}