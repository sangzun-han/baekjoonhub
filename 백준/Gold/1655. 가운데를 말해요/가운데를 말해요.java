import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2) -> o2-o1);
		PriorityQueue<Integer> min = new PriorityQueue<>();
		
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
		
			if(max.size() == min.size()) max.offer(num);
			else min.offer(num);
			
			if(!max.isEmpty() && !min.isEmpty() && max.peek() > min.peek()) {
				max.offer(min.poll());
				min.offer(max.poll());
			}
			sb.append(max.peek()).append("\n");
		}
		System.out.println(sb);
	}
}