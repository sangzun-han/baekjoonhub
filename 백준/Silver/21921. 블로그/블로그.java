import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int sum = 0;

        for(int i=0; i<X; i++) {
            sum += nums[i];
        }
        max = sum;
        int count = 1;

        for(int i=X; i<N; i++) {
            sum = sum - nums[i-X] + nums[i];
            if(sum > max) {
                max = sum;
                count = 1;
            } else if(sum==max) {
                count++;
            }
        }

        if(max==0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }



    }
}
