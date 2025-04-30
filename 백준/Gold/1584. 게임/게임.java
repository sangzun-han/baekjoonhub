import java.io.*;
import java.util.*;

class Point{
    int r;
    int c;
    int usedLife;
    
    Point(int r, int c, int usedLife) {
        this.r = r;
        this.c = c;
        this.usedLife = usedLife;
    }
}

public class Main {
    static int SIZE = 501;
    static int N,M;
    static int[][] map = new int[SIZE][SIZE];
    static int[][] zone = new int[SIZE][SIZE];
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int i=0; i<SIZE; i++) {
            Arrays.fill(zone[i], Integer.MAX_VALUE);
        }
        
        N = Integer.parseInt(br.readLine());
        
        for(int k=0; k<N; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            // 위험한 구역
            for(int i=Math.min(x1,x2); i<=Math.max(x1,x2); i++) {
                for(int j=Math.min(y1,y2); j<=Math.max(y1,y2); j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        M = Integer.parseInt(br.readLine());
        for(int k=0; k<M; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            // 죽음 구역
            for(int i=Math.min(x1,x2); i<=Math.max(x1,x2); i++) {
                for(int j=Math.min(y1,y2); j<=Math.max(y1,y2); j++) {
                    map[i][j] = 2;
                }
            }
        }
        
        map[0][0] = 0;
        bfs(0,0);
        
        System.out.println(zone[500][500] == Integer.MAX_VALUE ? -1 : zone[500][500]);
    }
    
    public static void bfs(int r, int c) {
        PriorityQueue<Point> queue = new PriorityQueue<>((a,b) -> a.usedLife - b.usedLife);
        queue.offer(new Point(r,c,0));
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            if (zone[p.r][p.c] < p.usedLife) continue;

            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                int nUsedLife = p.usedLife;
                
                
                if(nr>=0 && nr<SIZE && nc>=0 && nc<SIZE) {
                    if (map[nr][nc] == 2) continue;

                    int cost = nUsedLife + (map[nr][nc] == 1 ? 1 : 0);
                    
                    if(zone[nr][nc] > cost) {
                        zone[nr][nc] = cost;
                        queue.offer(new Point(nr,nc,cost));
                    }
                }
            }
        }
    }
}
