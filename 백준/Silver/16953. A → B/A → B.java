import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        int ans = 0;
        HashSet<Long> visited = new HashSet<>();

        Queue<long[]> queue = new ArrayDeque<>();

        queue.offer(new long[] {A,0});

        while(!queue.isEmpty()) {
            long[] numDist = queue.poll();
            long x = numDist[0];
            int dist = (int)numDist[1];

            if(!visited.add(x)) continue;

            if(x==B) {
                ans = dist+1;
                break;
            }

            String xplus = x+"1";
            long xplustoInt = Long.parseLong(xplus);
            long xmul = 2*x;

            if(xplustoInt<=B && !visited.contains(xplustoInt)) queue.offer(new long[] {xplustoInt,dist+1});
            if(xmul <= B && !visited.contains(xmul)) queue.offer(new long[] {xmul,dist+1});

        }

        if(ans==0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }
}




