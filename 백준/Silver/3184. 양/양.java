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
    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Point> wolfList = new ArrayList<>();
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        int totalWolf = 0;
        int totalSheep = 0;
        
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j]=='v') {
                    totalWolf++;
                    wolfList.add(new Point(i,j));
                }
                if(map[i][j]=='o') {
                    totalSheep++;
                }
            }
        }
        
        for(Point p: wolfList) {
            if(!visited[p.r][p.c]) {                
                String[] types = bfs(p.r, p.c);
                String type = types[0];
                
                if(type.equals("wolf")) {
                    totalWolf -= Integer.parseInt(types[1]);
                }
                
                if(type.equals("sheep")) {
                    totalSheep -= Integer.parseInt(types[1]);
                }
            }
        }
        
        System.out.println(totalSheep+" "+totalWolf);
    }
    
    static String[] bfs(int r, int c) {
        int sheep = 0;
        int wolf = 1;
        
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(r,c));
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc]) {
                    if(map[nr][nc]=='#') continue;
                
                    if(map[nr][nc]=='o') {
                        sheep++;
                    } else if(map[nr][nc]=='v') {
                        wolf++;
                    }
                    
                    queue.offer(new Point(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
        
        String[] type = new String[2];
        if(wolf < sheep) {
            type[0] = "wolf";
            type[1] = String.valueOf(wolf);
        
        }
        // 늑대가 더 많으니 양 죽음
        if(wolf >= sheep) {
            type[0] = "sheep";
            type[1] = String.valueOf(sheep);
        }
        
        return type;
        
    }
}
