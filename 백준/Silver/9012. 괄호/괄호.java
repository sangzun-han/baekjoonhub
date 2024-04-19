

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int count=0;
			char[] vps = br.readLine().toCharArray();
			
			for(int j=0; j<vps.length; j++) {
				if(vps[j]=='(') count++;
				else if(vps[j]==')') count--;
				
				if(count < 0) {
					System.out.println("NO");
					break;
				}
			}	
			if(count==0) System.out.println("YES");
			else if(count>0) System.out.println("NO");
		}
		
	}
}
