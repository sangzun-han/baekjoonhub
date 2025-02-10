import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int zeroCount = 0;
        int oneCount = 0;

        char prev = s.charAt(0);
        if(prev=='0') zeroCount++;
        else oneCount++;

        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) != prev) {
                if(s.charAt(i)=='0') zeroCount++;
                else oneCount++;
            }
            prev = s.charAt(i);
        }

        System.out.println(Math.min(zeroCount,oneCount));
    }
}
