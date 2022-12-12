import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static int[] names;
    static int[][] d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        names = new int[n+1];
        d = new int[1001][1002];
        for(int i=0; i<n; i++) {
            names[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<1001; i++) {
            Arrays.fill(d[i],-1);
        }
        int ans = recursive(1, names[0]+1);
        System.out.println(ans);
    }

    private static int recursive(int index, int count) {
        if(index==n) return 0;
        int ans = d[index][count];
        if (ans != -1) return ans;
        int blank = (m-(count-1));
        int result = blank*blank;
        ans = recursive(index+1, names[index]+1)+result;
        if(count + names[index] <= m) {
            int val = recursive(index+1, count+names[index]+1);
            if(ans > val) ans = val;
        }
        d[index][count] = ans;
        return ans;
    }
}