import java.io.*;
import java.util.*;

class Point {
    int r;
    int c;
    int count;
    
    Point(int r, int c, int count) {
        this.r = r;
        this.c = c;
        this.count = count;
    }
}

public class Main {
    static int n,m;
    static int[][] map;
    static Point start;
    
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split("");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j]==2) start = new Point(i,j,0);
            }
        }
        List<Integer> answerList = new ArrayList<>();
        
        int answer = bfs(start.r, start.c);
        
        if(answer==Integer.MAX_VALUE) {
            System.out.println("NIE");
        } else {
            System.out.println("TAK");
            System.out.println(answer);
        }
    }
    
    public static int bfs(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new Point(r,c, 0));
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            
            Point p = queue.poll();
            
            if(map[p.r][p.c]==3 || map[p.r][p.c]==4 || map[p.r][p.c]==5) return p.count;
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                int count = p.count;
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && map[nr][nc] != 1) {
                    queue.offer(new Point(nr, nc, count+1));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return Integer.MAX_VALUE;
    }
}
