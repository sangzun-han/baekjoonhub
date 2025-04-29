import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[] money = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        
        int left = 0;
        int right = findMax(money);
        
        while(left <= right) {
            int target = (left + right)/2;
            
            int useMoney= 예산요청(money, target);
            
            // System.out.printf("사용한 돈 : %d, 사용할 수 있는 돈 %d, 그 때 제시한 상한액 %d\n", useMoney,M, target);
            if(useMoney > M) {
                right = target - 1;
            } else {
                answer = target;
                left = target + 1;
            }
        }
        
        System.out.println(answer);
    }
    
    public static int 예산요청(int[] money, int target) {
        int sum = 0;
        for(int i=0; i<money.length; i++) {
            int m = money[i];
            
            if(m <= target) {
                sum += m;
            } else {
                sum += target;
            }
        }
        return sum;
    }
    
    public static int findMax(int[] money) {
        int max = 0;
        for(int i=0; i<money.length; i++) {
            max = Math.max(money[i], max);
        }
        
        return max;
    }
}
