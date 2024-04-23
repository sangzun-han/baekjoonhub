

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] reg = br.readLine().split("-");
		
		int ans=0;
		for(int i=0; i<reg.length; i++) {
			int sum=0;
			String[] plus = reg[i].split("\\+");
			
			for(int j=0; j<plus.length; j++) sum += Integer.parseInt(plus[j]);
			
			if(i==0) ans+=sum;
			else ans-=sum;
		}
		
		System.out.println(ans);
	}
}
