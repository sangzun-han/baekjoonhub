import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[8];
        for(int i=0; i<8; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int posCnt = 0;
        int negCnt = 0;
        for(int i=1; i<8; i++) {
            if(nums[i-1] - nums[i] == -1) posCnt++;
        }

        for(int i=0; i<7; i++) {
            if(nums[i+1] - nums[i] == -1) negCnt++;
        }

        if(posCnt==7) {
            System.out.println("ascending");
            return;
        }
        if(negCnt==7) {
            System.out.println("descending");
            return;
        }
        else System.out.println("mixed");

    }
}