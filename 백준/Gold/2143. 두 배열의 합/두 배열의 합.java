import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // target
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();


        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum += A[j];
                aList.add(sum);
            }
        }

        for(int i=0; i<m; i++) {
            int sum = 0;
            for(int j=i; j<m; j++) {
                sum += B[j];
                bList.add(sum);
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<bList.size(); i++) {
            if(map.containsKey(bList.get(i))) {
                int x = map.get(bList.get(i));
                map.put(bList.get(i),x+1);
            } else {
                map.put(bList.get(i),1);
            }
        }


        long ans = 0;
        for(int i=0; i<aList.size(); i++) {
            int x = aList.get(i);

            if(map.containsKey(T-x)) {
                ans += map.get(T-x);
            }
        }
        System.out.println(ans);
    }
}