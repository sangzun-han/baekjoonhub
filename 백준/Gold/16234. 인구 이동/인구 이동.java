import java.io.*;
import java.util.*;

class Point {
    int r;
    int c;
    
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N,L,R;
    static int[][] map;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        
        while(true) {
            boolean[][] visited = new boolean[N][N];
            boolean stop = true;
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        int count = open(i,j, visited);
                        if(count>1) stop = false;
                    }
                }
            }
            
            if(stop) break;
            
            answer++;
        }
        
        
        System.out.println(answer);
    }
    
    public static int open(int r, int c, boolean[][] visited) {
        Queue<Point> queue = new ArrayDeque<>();
        List<Point> peoples = new ArrayList<>();
        
        queue.offer(new Point(r,c));
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            peoples.add(new Point(p.r, p.c));
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && Math.abs(map[p.r][p.c] - map[nr][nc])>=L && Math.abs(map[p.r][p.c]- map[nr][nc])<=R) {
                    queue.offer(new Point(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
        
        int sum = 0;
        
        for(int i=0; i<peoples.size(); i++) {
            Point p = peoples.get(i);
            sum += map[p.r][p.c];
        }
        
        int changePeoples = sum / peoples.size();
        
        for(Point p: peoples) {
            map[p.r][p.c] = changePeoples;
        }
        
        return peoples.size();
    }
}
