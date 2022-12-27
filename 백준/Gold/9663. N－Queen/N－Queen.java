import java.util.*;
import java.io.*;

public class Main {
    static int result = 0;
    static int N;
    //퀸의 위치 표시
    static int[][] map;
    //퀸을 놓을 수 있는지 없는지
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        dfs(0);
        System.out.println(result);

    }

    static void dfs(int cnt) {
        if(cnt == N) {
            result++;
            return;
        }

        for(int j=0; j<N; j++) {
            if(!visited[cnt][j]) {
                visited[cnt][j] = true;
                //현재 퀸의 위치
                map[cnt][j] = 1;

                //퀸의 공격방향 체크해주고
                check_queen_Attack(cnt , j);

                dfs(cnt+1);

                //이전 상태로 돌아가기
                map[cnt][j] = 0;   //퀸을 빼고
                init_visited();      //초기화를 시킨뒤

                //이전에 두었던 퀸의 위치 복원 --> 이게 뭔소리나면 위에 init_visited()를 해버리면 현재 cnt말고도 이전에 퀸 위치마저 초기화시키니깐
                //이전 map ==1인 퀸의 값을 찾아서 check_queen_Attack()시켜야됨
                for(int i=0; i<N; i++) {
                    for(int p=0; p<N; p++) {
                        if(map[i][p] == 1) check_queen_Attack(i, p);
                    }
                }
            }
        }
    }

    //   퀸의 공격 방향 표시하는 메소드
    public static void check_queen_Attack(int a, int b) {
        /* 아래 방향 */
        for (int i = a; i < N; i++) {
            visited[i][b] = true;
        }
        /* 왼쪽 대각선 */
        int c = a;
        int d = b;
        while (0 <= d && d < N & 0 <= c & c < N) {
            visited[c++][d--] = true;
        }
        /* 오른쪽 대각선 */
        while ((0 <= a && a < N & (0 <= b && b < N))) {
            visited[a++][b++] = true;
        }
    }
    /* 체스판 초기화 시키는 메소드 */
    public static void init_visited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }

}