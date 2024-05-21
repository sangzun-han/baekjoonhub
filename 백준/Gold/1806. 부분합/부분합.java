import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = 0;
		int sum = nums[0];
		int ans = Integer.MAX_VALUE;
		
		while(left <= right && right < N) {
			if(sum < S) {
				right += 1;
				sum += nums[right];
			} else if(sum == S) {
				ans = Math.min(right-left+1, ans);
				right += 1;
				sum += nums[right];
			} else if(sum > S) {
				ans = Math.min(right-left+1, ans);
				sum -=nums[left];
				left+=1;
			}
		}
		if(ans > N) {
			System.out.println(0);
			System.exit(0);
		}
		System.out.println(ans);
		
		
	}
}
