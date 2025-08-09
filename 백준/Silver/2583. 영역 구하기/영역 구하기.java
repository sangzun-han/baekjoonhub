import java.io.*;
import java.util.*;

class Point {
    int r;
    int c;
    
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N,M,K;
    static int[][] board;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static boolean[][] visited;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        
        board = new int[N][M];
        visited = new boolean[N][M];
        
        for(int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            
            for(int i=x1; i<x1+x2-x1; i++) {
                for(int j=y1; j<y1+y2-y1; j++) {
                    board[i][j] = 1;
                }
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j]==0 && !visited[i][j]) {
                    list.add(bfs(i,j));
                }
            }
        }
        
        Collections.sort(list);
        
        System.out.println(list.size());
        
        for(int n: list) {
            System.out.print(n+" ");
        }
    }
    
    public static int bfs(int r, int c) {
        int count = 1;
        Queue<Point> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.offer(new Point(r,c));
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && board[nr][nc]==0) {
                    queue.offer(new Point(nr,nc));
                    visited[nr][nc] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}
