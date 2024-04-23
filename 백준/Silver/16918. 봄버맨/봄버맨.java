import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static int[][] bomb;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int R,C,N;
    static int time;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        time = 0;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
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


        // 1초 에는 아무것도 하지 않음
        // 2초 에는 폭탄이 설치되어 있지 않은 모든 칸에 폭탄 설치
        // 3초 3초전에 설치된 폭탄이 모두 폭발

        while(time<N) {
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
