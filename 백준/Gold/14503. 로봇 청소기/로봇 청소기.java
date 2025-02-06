import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 시작좌표
        int c = Integer.parseInt(st.nextToken()); // 시작좌표
        int d = Integer.parseInt(st.nextToken()); // 현재 방향

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 청소 안된곳이면 청소한다.
        // 청소 됐다면 4칸 확인한다.
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                answer++;
            }
            boolean flag = false;
            for (int dd = 0; dd < 4; dd++) {
                int nx = r + dx[dd];
                int ny = c + dy[dd];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 0) { // 청소할곳이 있다.
                    flag = true;
                    break;
                }
            }
            // flag = false, 모두 청소 돼있다.
            if (flag) {
                // 청소할곳이 있다. 반시계 회전, 한칸 전진
                for (int i = 0; i < 4; i++) {
                    d = (d + 3) % 4;
                    int nx = r + dx[d];
                    int ny = c + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                        r = nx;
                        c = ny;
                        break;
                    }
                }


            }
            // 청소할곳이 없다 -> 후진하고 1번, 후진못한다면 멈춤
            else {
                // 현재 바라보는 방향에서 후진한다.
                int nx = r + dx[(d + 2) % 4];
                int ny = c + dy[(d + 2) % 4];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1) {
                    r = nx;
                    c = ny;
                } else {
                    break; // 후진 불가 시 종료
                }
            }
        }

        System.out.println(answer);
    }
}
