import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] storage = new int[1001];
        
        int max = 0;
        int maxIndex = 0;
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            if(max < H) {
                max = H;
                maxIndex = L;
            }
            
            storage[L] = H;
        }
        
        int leftSum = leftToMax(storage, 0, maxIndex);
        int rightSum = rightToMax(storage, storage.length-1, maxIndex);
        System.out.println(leftSum + rightSum + max);
    }
    
    public static int leftToMax(int[] storage, int left, int index) {
        int prev = 0;
        int sum = 0;
        
        while(left<index) {
            if(prev < storage[left]) prev = storage[left];
            sum += prev;
            left++;
        }
        return sum;
    }
    
    public static int rightToMax(int[] storage, int right, int index) {
        int prev = 0;
        int sum = 0;
        
        while(right>index) {
            if(prev < storage[right]) prev = storage[right];
            sum += prev;
            right--;

        }
        return sum;
    }
}