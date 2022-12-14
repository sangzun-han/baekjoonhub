import java.io.*;
import java.util.*;
public class Main {
    static int N,C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[] house = new int[N];

        for(int i=0; i<N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house); // 입력받은값 정렬
        int low = 1;
        int high = house[N-1] - house[0] + 1;
        int mid = 0;
        while(low < high) {
            int count = 1;
            int prev = house[0];
            mid = (low + high) / 2;

            // 해당 거리에 대해 설치 가능한 공유기는 몇개?
            for(int i=0; i<house.length; i++) {

                int loc = house[i];
                if(loc - prev >= mid) {
                    count++;
                    prev = loc;
                }
            }

            if(count < C) {
                high = mid;
            } else {
                low =  mid+1;
            }
        }

        System.out.println(low-1);
    }
}