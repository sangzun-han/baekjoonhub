import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 집 갯수
            int M = Integer.parseInt(st.nextToken()); // 돈을 훔칠 연속된 집의 개수
            int K = Integer.parseInt(st.nextToken()); // 자동 방범 장치가 작동하는 최소 돈의 양
            int[] home = new int[N]; // 집
            int ans = 0;
            int sum = 0; // 합을 계산하기 위한 변수
            int sum2 = 0; // n과 m이 같을때 계산할 변수
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                home[i] = Integer.parseInt(st.nextToken()); // 집에 있는 돈의 양
                sum2 += home[i];
            }

            if(N==M) {
                if(sum2<K) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            } else {
                int left = 0;
                int right = M-1;
                // 항상 left와 right는 M개만큼 차이나도록
                for(int i=0; i<=right; i++) {
                    sum += home[i];
                }

                while(left < N) {
                    if(sum < K) ans++;
                    sum -= home[left];
                    left++;
                    right++;
                    sum += home[(right)%N];
                }
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }
}