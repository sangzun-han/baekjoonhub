import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[] A = new long[n];
        long[] B = new long[n];
        long[] C = new long[n];
        long[] D = new long[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }
        long[] sumAB = new long[n*n];
        long[] sumCD = new long[n*n];

        // A와 B의 쌍 모든 합을 구한다 => O(4000^2)
        // C와 D의 쌍의 모든 합을 구한다 => O(4000^2)
        int idx = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sumAB[idx] = A[i]+B[j];
                sumCD[idx] = C[i]+D[j];
                idx++;
            }
        }


        // 투 포인터를 사용하기 위해 정렬
        Arrays.sort(sumAB);
        Arrays.sort(sumCD);

        long ans = 0;
        int left = 0;
        int right = sumCD.length-1;
        while(left < sumAB.length && right >= 0) {
            long sum = sumAB[left] + sumCD[right];
            if(sum == 0) {
                long cnt1 = 0;
                long cnt2 = 0;
                long value1 = sumAB[left];
                long value2 = sumCD[right];

                while(left < sumAB.length && value1==sumAB[left]) {
                    left++;
                    cnt1++;
                }
                while(right >=0 && value2==sumCD[right]) {
                    right--;
                    cnt2++;
                }
                ans += cnt1*cnt2;
            }
            else if(sum > 0) right--;
            else if (sum < 0) left++;
        }
        System.out.println(ans);


    }
}