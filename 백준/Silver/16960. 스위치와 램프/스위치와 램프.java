import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 스위치
        int M = Integer.parseInt(st.nextToken()); // 램프

        ArrayList<Integer>[] list = new ArrayList[N+1];
        int[] counting = new int[M+1];

        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++) {
                int lamp = Integer.parseInt(st.nextToken());
                counting[lamp]++;
                list[i].add(lamp);
            }
        }

        for(int i=1; i<=N; i++) {
            boolean flag = true;

            for(int num :list[i]) {
                counting[num]--;
                if(counting[num]<=0) {
                    flag = false;
                }
            }

            for(int num: list[i]) {
                counting[num]++;
            }

            if(flag) {
                System.out.println(1);
                return;
            }

        }
        System.out.println(0);

    }
}
