import java.io.*;
import java.util.*;

class Coordinate {
    int r;
    int c;
    
    Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N, M, L, K;
    static List<Coordinate> coordinates = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()); // 트램펄린 한 변 길이
        K = Integer.parseInt(st.nextToken()); // 별 개수

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            coordinates.add(new Coordinate(r, c));
        }

        int answer = 0;

        // 별 하나 기준으로 → 사각형 왼쪽 아래 꼭짓점을 (r-L, c-L) ~ (r, c) 범위로 이동시키면서 시도
        for (Coordinate base1 : coordinates) {
            for (Coordinate base2 : coordinates) {
                int startR = base1.r;
                int startC = base2.c;

                int count = 0;

                for (Coordinate star : coordinates) {
                    if (startR <= star.r && star.r <= startR + L &&
                        startC <= star.c && star.c <= startC + L) {
                        count++;
                    }
                }

                answer = Math.max(answer, count);
            }
        }

        System.out.println(K - answer); 
    }
}
