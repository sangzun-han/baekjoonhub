import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int[] datas = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			datas[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(datas);
		int left = 0;
		int right = N-1;
		int ansLeft = 0;
		int ansRight = 0;
		int findNum = Integer.MAX_VALUE;
		while(left < right && right < N) {
			int sum = datas[left] + datas[right];

			if(Math.abs(findNum) > Math.abs(sum)) {
				findNum = Math.abs(sum);
				ansLeft = datas[left];
				ansRight = datas[right];
				
				if(sum == 0) break;
			} 
			if(sum < 0) left++;
			if(sum > 0) right--;
			
		}
		System.out.println(ansLeft+" "+ansRight);
	}
}