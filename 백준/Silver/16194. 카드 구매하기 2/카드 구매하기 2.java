import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N+1];
		
		// dp[n] : 카드 n개 샀을 때 최소비용
		int[] dp = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			dp[i] = 10000000;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j]+cards[j]);
			}
		}
		System.out.println(dp[N]);
	}
}
