import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> aMap = new HashMap<>();
        HashMap<Integer, Integer> bMap = new HashMap<>();


        st = new StringTokenizer(br.readLine());

        for(int i=0; i<a; i++) {
            int num = Integer.parseInt(st.nextToken());
            aMap.put(num,1);
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<b; i++) {
            int num = Integer.parseInt(st.nextToken());
            bMap.put(num,1);
        }

        int originASize = aMap.size();
        int originBSize = bMap.size();

        int cnt = 0;
        //A-B 구하기
        for(int num: bMap.keySet()) {
            cnt = aMap.getOrDefault(num,0);
            originASize -= cnt;
        }


        cnt = 0;
        // b-a 구하기
        for(int num: aMap.keySet()) {
            cnt = bMap.getOrDefault(num,0);
            originBSize -= cnt;

        }

        System.out.println(originBSize + originASize);


    }
}


