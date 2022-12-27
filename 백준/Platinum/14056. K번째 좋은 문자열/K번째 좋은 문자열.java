import java.io.*;
import java.util.*;

public class Main {
    static String S;
    static int K;
    static ArrayList<String> d = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        K = Integer.parseInt(br.readLine());
        d.add("()");

        // 좋은 문자열을 모두 만듬
        for(int i=4; i<=S.length(); i+=2) {
            for(int j=0; j<d.size(); j++) {
                String cur = d.get(j);

                if( (i-2) % cur.length() == 0) {
                    String s ="";
                    s += "(";
                    for(int k=0; k<(i-2)/cur.length(); k++) {
                        s+=cur;
                    }
                    s += ")";
                    d.add(s);
                }
            }
        }

        Collections.sort(d);

        for(String s: d) {
            int index = 0;
            for(int i=0; i<S.length(); i++) {
                if(index < s.length()) {
                    if(s.charAt(index) == S.charAt(i)) index++;
                }
            }

            if(index==s.length()) {
                K--;
                if(K==0) {
                    System.out.println(s);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}