import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] W;
	static int[] city;
	static boolean[] visited;
	static int[] nums;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		W = new int[N][N];
		visited = new boolean[N];
		city = new int[N];
		nums = new int[N];
		
		for(int i=0; i<N; i++) {
			city[i] = i;
		}
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		System.out.println(ans);
	}
	private static void perm(int cnt) {
		boolean flag = true;
		int sum = 0;
		
		if(cnt==N) {
			for(int i=0; i<N-1; i++) {
				if(W[nums[i]][nums[i+1]]==0) {
					flag = false; 

				} else {
					sum += W[nums[i]][nums[i+1]];
				}
			}
			if(flag && W[nums[N-1]][nums[0]] != 0) {
				sum += W[nums[N-1]][nums[0]];
				
				ans = Math.min(sum,ans);
			}
		
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			nums[cnt] = city[i];
			perm(cnt+1);
			visited[i] = false;
		}
	}
}