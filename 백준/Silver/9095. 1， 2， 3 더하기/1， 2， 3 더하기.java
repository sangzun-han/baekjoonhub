import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] d= new int[11];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		
		for(int tc=0; tc<T; tc++) {
			n = Integer.parseInt(br.readLine());

			for(int i=3; i <= n;i ++) {
				d[i] = d[i-3] + d[i-2] + d[i-1];
			}
			System.out.println(d[n]);
		}
	}
}
	