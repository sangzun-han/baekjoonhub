

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * D[n] = n을 1로 만드는 최소 연산 횟수
 * n -> n/3 1번
 * n/3 -> 1 +  D[n/3]
 * D[n] = min(D[n/3], D[n/2], D[n-1]) + 1
 */
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[n+1];
		
		for(int i=2; i<=n; i++) {
			d[i] = d[i-1] + 1;
			if(i%2==0 && d[i] > d[i/2]+1) {
				d[i] = d[i/2]+1;
			}
			if(i%3==0 && d[i] > d[i/3]+1) {
				d[i] = d[i/3]+1;
			}
		}
		System.out.println(d[n]);
		
	}
}
