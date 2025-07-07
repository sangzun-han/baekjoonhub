import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] 용액 = new int[N];
        
        for(int i=0; i<N; i++) {
            용액[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = N-1;
        
        int answer = Integer.MAX_VALUE;
        int answerLeft = 0;
        int answerRight = 0;
        
        while(left < right) {
            int sum = 용액[left] + 용액[right];
            
            if(Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
                answerLeft = left;
                answerRight = right;
            }
            
            if(sum < 0) {
                left++;    
            } else if(sum > 0) {
                right--;
            } else if (sum == 0) {
                break;
            }
        }
        
        System.out.print(Math.min(용액[answerLeft],용액[answerRight])+" ");
        System.out.print(Math.max(용액[answerLeft],용액[answerRight]));
    }
}
