import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] d = new int[101]; // d[i] : i에 도착하는 최소 주사위 던진 횟수
    static int[] next = new int[101]; // next[i] : 주사위 1~6이 나왔을 때 도착한 칸이 i일때 이동해야 하는 위치

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=100; i++) {
            d[i] = -1;
            next[i] = i;
        }

        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            next[x] = y;
        }

        d[1] = 0;
        bfs();
        System.out.println(d[100]);
    }
    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); // 게임의 시작점 1
        while(!queue.isEmpty()) {
            int x = queue.poll();

            // 주사위의 값 1~6까지 모두 시도
            for(int i=1; i<=6; i++) {
                int y = x+i; // 주사위를 던지고 이동한 칸
                if(y>100) continue; // 100번째 칸이 마지막이기 때문에 100 이상이 나오면 pass
                y = next[y]; // 주사위를 던지고 이동한 칸이 뱀이나 사다리를 타야된다면 그쪽으로 이동
                // 만약 y로 이동한적이 없다면
                if(d[y]==-1) {
                    d[y] = d[x] + 1; // 주사위 던진횟수를 이전 값인 d[x]에서 1더하기
                    queue.offer(y); // 큐에 넣어주기
                }
            }
        }

    }
}