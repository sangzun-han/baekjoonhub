import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] d = new int[k+1];
        int[] c = new int[n+1];

        for(int i=1; i<=n; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=k; i++) {
            d[i] = 10001;
        }


        for(int i=1; i<=n; i++) {
            for(int j=c[i]; j<=k; j++) {
                d[j] = Math.min(d[j], d[j-c[i]]+1);
            }
        }

        int ans = d[k] == 10001 ? -1 : d[k];
        System.out.println(ans);

    }
}
