import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int A = Integer.parseInt(br.readLine());
        int[] nums = new int[A];
        int[] d = new int[A];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<A; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            d[i] = nums[i];
        }

        for(int i=0; i<A; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    d[i] = Math.max(d[i], d[j]+nums[i]);
                }
            }
        }

        int max = 0;
        for(int i=0; i<A; i++) {
            max = Math.max(max, d[i]);
        }

        System.out.println(max);

    }
}

