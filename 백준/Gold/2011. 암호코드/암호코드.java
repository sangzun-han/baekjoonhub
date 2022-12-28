import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        int length = nums.length();
        int[] numArray = new int[length+1];
        int[] d = new int[length+1];
        int mod = 1000000;
        for(int i=0; i<nums.length(); i++) {
            numArray[i+1] = nums.charAt(i) - '0';
        }

        d[0] = 1;

        for(int i=1; i<=length; i++) {
            if(numArray[i] != 0) {
                d[i] = (d[i-1]+ d[i])%mod;
            }
            int x = numArray[i-1]*10 + numArray[i];
            if(x>=10 && x<=26) d[i] = (d[i-2] + d[i])%mod;
        }

        System.out.println(d[length]%mod);
    }
}