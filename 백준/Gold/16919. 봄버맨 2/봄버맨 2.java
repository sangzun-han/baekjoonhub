import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static char[][][] saveMap;
    static int[][] bomb;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int R,C;
    static long N;
    static int time;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        time = 0;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Long.parseLong(st.nextToken());
        saveMap = new char[4][R][C];

        map = new char[R][C];
        bomb = new int[R][C];



        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='O') {
                    bomb[i][j] = 3;
                }

            }
        }

        //초기 세팅
        if(N==1) {
            printMap(1);
            return;
        }
        // 모두 'O'
        if(N%2==0) {
            printMap(2);
            return;
        }
        // 3초후
        if(N%4==3) {
            printMap(3);
        }
        //  5초 후
        if(N>1 && N%4==1) {
            printMap(5);
        }




    }

    private static void printMap(int cnt) {
        while(time<cnt) {
            time++;
            if(time%2==0) {
                for(int i=0; i<R; i++) {
                    for(int j=0; j<C; j++) {
                        if(map[i][j]=='.') {
                            map[i][j] = 'O';
                            bomb[i][j] = time + 3;
                        }
                    }
                }
            }
            else if(time%2==1) {
                for(int i=0; i<R; i++) {
                    for(int j=0; j<C; j++) {
                        if(bomb[i][j] - time == 0) {
                            map[i][j] = '.';
                            for(int d=0; d<4; d++) {
                                int nx = i + dx[d];
                                int ny = j + dy[d];

                                if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]=='O') {
                                    map[nx][ny] = '.';

                                }
                            }
                        }
                    }
                }
            }

        }
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }


    }
}
