import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine());
            char[] A = st.nextToken().toCharArray();
            char[] B = st.nextToken().toCharArray();
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            int ans = 0;
            for(int i=0; i<A.length; i++) {
                if(A[i]=='a') aList.add(i);
                if(B[i]=='a') bList.add(i);
            }

            for(int i=0; i<aList.size(); i++) {
                if(aList.get(i) != bList.get(i)) {
                    ans += Math.abs(aList.get(i) - bList.get(i));
                }
            }
            System.out.println(ans);

        }
    }
}