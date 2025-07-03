import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] blockHeight = new int[W];
        int maxHeight = 0;
        int maxHeightIndex = 0;
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<W; i++) {
            int height = Integer.parseInt(st.nextToken());
            blockHeight[i] = height;
            
            if(maxHeight <= height) {
                maxHeight = height;
                maxHeightIndex = i;
            }
        }
        
        int currentMax = blockHeight[0];
        
        for(int i=1; i<maxHeightIndex; i++) {            
            if(currentMax >= blockHeight[i]) {
                answer += currentMax - blockHeight[i];
            } else {
                currentMax = blockHeight[i];
            }
        }
        
        currentMax = blockHeight[W-1];
        
        for(int i=W-1; i>=maxHeightIndex; i--) {
            if(currentMax >= blockHeight[i]) {
                answer += currentMax - blockHeight[i];
            } else {
                currentMax = blockHeight[i];
            }
        }
        
        System.out.println(answer);
        
    }
}

// 왼쪽 오른쪽 나눠서 큰값으로 계산하면 예외 2,0,3,1,4
