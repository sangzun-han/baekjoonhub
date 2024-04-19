import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<k-1; j++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()+", ");
		}
		
		sb.append(queue.poll()+">");
		System.out.println(sb);
	}
}
