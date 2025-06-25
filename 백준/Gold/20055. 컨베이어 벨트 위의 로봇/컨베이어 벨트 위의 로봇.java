import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] belt;          
    static boolean[] robot;     

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); 
        k = Integer.parseInt(st.nextToken()); 

        belt = new int[2 * n];     
        robot = new boolean[n];    

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int round = 0;

        while (true) {
            round++;

            rotate();       // 1단계: 벨트와 로봇 회전
            move();         // 2단계: 로봇 이동
            put();          // 3단계: 로봇 올리기
            if (countZero() >= k) break;  // 4단계: 내구도 0 체크
        }

        System.out.println(round);
    }

    public static void rotate() {
        int last = belt[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = last;
        
        for (int i = n - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;      // 올리는 위치는 비워둠
        robot[n - 1] = false;  // 내리는 위치는 비워둠
    }

    public static void move() {
        for (int i = n - 1; i > 0; i--) {
            if (robot[i - 1] && !robot[i] && belt[i] > 0) {
                robot[i] = true;
                robot[i - 1] = false;
                belt[i]--;
            }
        }
        robot[n - 1] = false;
    }

    public static void put() {
        if (belt[0] > 0) {
            robot[0] = true;
            belt[0]--;
        }
    }

    public static int countZero() {
        int count = 0;
        for (int d : belt) {
            if (d == 0) count++;
        }
        return count;
    }
}
