import java.io.*;
import java.util.*;
public class Main {
    static int R,C,N;
    static char[][] map;
    static int[][] bomb;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        bomb = new int[R][C];
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j]=='O') bomb[i][j] = 3;
            }
        }

        int time = 0;
        while(time++<N) {

            // 모든 칸에 폭탄 설치
            if(time%2==0) {
                for(int i=0; i<R; i++) {
                    for(int j=0; j<C; j++) {
                        if(map[i][j]=='.') {
                            map[i][j] = 'O';
                            bomb[i][j] = time+3;
                        }
                    }
                }
            }
            // 3초전 폭탄이 모두 폭발
            else if(time%2==1) {
                for(int i=0; i<R; i++) {
                    for(int j=0; j<C; j++) {
                        if(bomb[i][j]-time == 0) {
                            map[i][j] = '.'; // 시간이 됐으므로 폭탄 터트림
                            for(int d=0; d<4; d++) {
                                int nx = i + dx[d];
                                int ny = j + dy[d];

                                // 그 주위에 있는 애들
                                if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]=='O' && bomb[nx][ny]-time!=0) {
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
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }
    }
}