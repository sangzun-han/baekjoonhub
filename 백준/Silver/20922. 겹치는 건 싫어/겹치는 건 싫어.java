import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] numberCount = new int[100001];
        int[] arr = new int[N+1];
        
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if(N==1) {
            System.out.println(1);
            return;
            
        }
        
        int left = 0;
        int right = 0;
        int answer = 0;
        int count = 0;
        
        while (right < N) {
            int number = arr[right];
            
            numberCount[number]++;

            while (numberCount[number] > K) {
                numberCount[arr[left]]--;
                left++;
            }
            
            answer = Math.max(answer, right - left + 1);
            right++;
        }

        System.out.println(answer);
    }
}



