import java.io.*;
import java.util.*;

public class Main {
    static int N,K,P,X;
    static Map<Integer, List<Integer>> displayLED = new HashMap<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        displayLED.put(0, new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        displayLED.put(1, new ArrayList<>(Arrays.asList(3,4)));
        displayLED.put(2, new ArrayList<>(Arrays.asList(2,3,5,6,7)));
        displayLED.put(3, new ArrayList<>(Arrays.asList(2,3,4,5,7)));
        displayLED.put(4, new ArrayList<>(Arrays.asList(1,3,4,7)));
        displayLED.put(5, new ArrayList<>(Arrays.asList(1,2,4,5,7)));
        displayLED.put(6, new ArrayList<>(Arrays.asList(1,2,4,5,6,7)));
        displayLED.put(7, new ArrayList<>(Arrays.asList(2,3,4)));
        displayLED.put(8, new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
        displayLED.put(9, new ArrayList<>(Arrays.asList(1,2,3,4,5,7)));

        N = Integer.parseInt(st.nextToken()); // N보다 커질수는 없음
        K = Integer.parseInt(st.nextToken()); // K자리 숫자
        P = Integer.parseInt(st.nextToken()); // P개 까지 반전가능
        X = Integer.parseInt(st.nextToken()); // 현재 위치
    
        int[] currentDigits = toDigits(X,K);
        int answer = 0;
        
        for(int i=1; i<=N; i++) {
            if(i==X) continue;
            int[] digits = toDigits(i, K);
            int count = diff(currentDigits, digits);
            if(count <= P) answer++;
        }
        
        System.out.println(answer);
        
        
    }
    
    public static int[] toDigits(int num, int k) {
        int[] res = new int[k];
        for(int i=k-1; i>=0; i--) {
            res[i] = num%10;
            num /= 10;
        }
        
        return res;
    }
    
    public static int diff(int[] digitsA, int[] digitsB) {
        int length = digitsA.length;
        int count = 0;
        
        for(int i=0; i<length; i++) {
            int partA = digitsA[i];
            int partB = digitsB[i];
            if(partA==partB) continue;
            List<Integer> aLedList = displayLED.get(partA);
            List<Integer> bLedList = displayLED.get(partB);
            
            Set<Integer> union = new HashSet<>(aLedList);
            union.addAll(bLedList);
            
            for(int num: union) {
                boolean inA = aLedList.contains(num);
                boolean inB = bLedList.contains(num);
                
                if(inA != inB) count++;
            }
        }
        
        return count;
    }
}
