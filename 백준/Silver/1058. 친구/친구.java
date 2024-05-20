import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        int[][] connected = new int[N][N];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i==j) continue;

                    if(map[i][j] == 'Y' || (map[i][k]=='Y' && map[k][j]=='Y')) {
                        connected[i][j] = 1;
                    }
                }
            }
        }

        int ans = -1;
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=0; j<N; j++) {
                sum += connected[i][j];
            }
            ans = Math.max(sum,ans);
        }
        System.out.println(ans);

    }
}