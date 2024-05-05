import java.io.*;
import java.util.*;

public class Main {
    static int N,ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy ={0,1,0,-1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        ans = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(ans);
    }

    private static void dfs(int cnt, int sum) {
        if(cnt==3) {
            ans = Math.min(ans,sum);
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 현재 위치 + 4방향 모두 방문하지 않았다면
                if(!visited[i][j] && isCheck(i,j)) {
                    int cost = map[i][j];
                    visited[i][j] = true;
                    for(int d=0; d<4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        visited[nx][ny] = true;
                        cost += map[nx][ny];
                    }
                    dfs(cnt+1, sum+cost);
                    visited[i][j] = false;
                    for(int d=0; d<4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }

    private static boolean isCheck(int x, int y) {
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx<0 || nx>=N || ny<0 || ny>=N || visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }
}

// visited 배열로 갈수있는지 체크해버리기
// 현재 위치 기준으로 4기준 값 더해서 최소값.
// 3개 선택해서 1,2반복