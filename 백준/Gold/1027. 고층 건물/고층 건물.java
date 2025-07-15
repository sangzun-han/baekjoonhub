import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i=1; i<=N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        
        for(int i=1; i<=N; i++) {
            int rightCount = 0;
            int leftCount = 0;
            int height = heights[i];
            

            for(int j = i+1; j <= N; j++) {
                double x증가량 = j - i; 
                double y증가량 = heights[j] - height;
                double 기울기 = y증가량 / x증가량;
                
                boolean canSee = true;
                
                for(int k = i+1; k < j; k++) {
                    double kHeight = height + 기울기 * (k - i);
                    if(heights[k] >= kHeight) {
                        canSee = false;
                        break;
                    }
                }
                if(canSee) rightCount++;
            }
            
    
            for(int j = i-1; j >= 1; j--) {
                double x증가량 = i - j;
                double y증가량 = heights[j] - height;
                double 기울기 = y증가량 / x증가량;
                
                boolean canSee = true;
                for(int k = i-1; k > j; k--) {
                    double kHeight = height + 기울기 * (i - k);
                    if(heights[k] >= kHeight) {
                        canSee = false;
                        break;
                    }
                }
                if(canSee) leftCount++;
            }
            
            answer = Math.max(answer, rightCount + leftCount);
        }
        
        System.out.println(answer);
    }
}
