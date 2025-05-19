import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짖수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] eat = new int[d+1];
        int[] sushi = new int[N];

        for(int i=0; i<N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;

        for(int i=0; i<k; i++) {
            if(eat[sushi[i]] == 0) count++;
            eat[sushi[i]]++;
        }

        int max = count;

        if(eat[c] == 0) max++;

        for (int start = 1; start < N; start++) {
            int end = (start + k - 1) % N;
            int prev = (start - 1) % N;
            eat[sushi[prev]]--;
            if (eat[sushi[prev]] == 0) count--;
            if (eat[sushi[end]] == 0) count++;
            eat[sushi[end]]++;
            
            int currentMax = count;        
                
            if (eat[c] == 0) currentMax++;
            
            max = Math.max(max, currentMax);
        }

        System.out.println(max);


    }
}
