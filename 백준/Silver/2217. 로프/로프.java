import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }

        Arrays.sort(nums);

        int max = 0;

        int cnt = 1;
        for(int i=N-1; i>=0; i--) {
            nums[i] = nums[i] * (cnt++);
            max = Math.max(nums[i], max);
        }

        System.out.println(max);
    }
}
