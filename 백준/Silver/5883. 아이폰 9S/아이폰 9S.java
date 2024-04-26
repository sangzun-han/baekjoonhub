import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        int[] nums = new int[N];

        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            set.add(nums[i]);
        }

        int ans = 1;

        for(int s: set) {
            int cnt = 1;
            int prev = nums[0];

            for(int i=1; i<N; i++) {
                // 현재 제거해봐야되는 값이면 같은값이면 패스
                if(nums[i]==s) continue;
                // 이전값과 다르면 초기화
                if(prev != nums[i]) cnt=1;
                // 제거해야되는것도 아니고 값이 같으면 카운트++
                else {
                    cnt++;
                    ans = Math.max(ans,cnt);
                }
                prev = nums[i];
            }
        }

        System.out.println(ans);

    }
}
