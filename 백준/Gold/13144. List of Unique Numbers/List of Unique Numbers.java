import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());    
        }

        Map<Integer, Boolean> map = new HashMap<>();
        int left = 0;
        long answer = 0;

        for(int right = 0; right < N; right++) {
            while(map.getOrDefault(nums[right], false)) {
                map.put(nums[left], false);
                left++;
            }
            map.put(nums[right], true);
            answer += (right - left + 1);
        }

        System.out.println(answer);
    }
}
