import java.io.*;
import java.util.*;

public class Main {
    static char[] s = new char[1001];
    static char[] p = new char[1001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().toCharArray();
        p = br.readLine().toCharArray();

        int cnt = 0;
        int idx = 0;

        while(idx < p.length){
            int c = 0;
            for(int j=0; j<s.length; j++) {
                int temp = 0;

                while(j+temp < s.length && idx+temp < p.length && s[j+temp] == p[idx+temp]) temp++;
                if(c < temp) c = temp;
            }
            idx += c;
            cnt++;
        }
        System.out.println(cnt);
    }
}