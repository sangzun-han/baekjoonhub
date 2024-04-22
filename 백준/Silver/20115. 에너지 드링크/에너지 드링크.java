import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        double[] drinks = new double[N];
        st = new StringTokenizer(br.readLine());


        for(int i=0; i<N; i++) {
            drinks[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(drinks);

        double ans = drinks[N-1];


        for(int i=N-2; i>=0; i--) {
            ans += drinks[i]/2;
        }

        System.out.println(ans);
    }
}




