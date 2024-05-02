import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left=0;
        int right=0;
        int odd=0; // 홀
        int even=0; // 짝
        int answer = 0;

        while(right<N) {
            if(odd > K) {
                if(nums[left]%2==0) even--;
                else odd--;
                left++;
            } else {
                if(nums[right]%2==0) even++;
                else odd++;
                right++;
                answer = Math.max(answer,even);
            }
        }

        System.out.println(answer);

    }
}
