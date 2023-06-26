import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean flag = false;
    static Queue<Point> water = new ArrayDeque<>();
    static Queue<Point> swan = new ArrayDeque<>();
    static ArrayList<Point> swanPos = new ArrayList<>();
    static int day=0;
    
    static class Point {
        int x,y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j]=='L') {
                    swanPos.add(new Point(i,j));
                    water.offer(new Point(i,j));
                    map[i][j] = '.';
                } else if(map[i][j]=='.') {
                    water.offer(new Point(i,j));
                }
            }
        }
        
       
       check();
        
    }

    private static void check() {

		Point p = swanPos.get(0);
		visited[p.x][p.y] = true;
		swan.offer(new Point(p.x, p.y));
		
		while(true) {
			boolean flag = false;
			Queue<Point> next = new ArrayDeque<>();
			
			while(!swan.isEmpty()) {
				Point po = swan.poll();
				
				if(po.x == swanPos.get(1).x && po.y == swanPos.get(1).y) {
					flag = true;
					break;
				}
				
				for(int d=0; d<4; d++) {
					int nx = po.x + dx[d];
					int ny = po.y + dy[d];
					
					if(nx<0 || nx>=R || ny<0 || ny>=C || visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					if(map[nx][ny]=='.') swan.offer(new Point(nx,ny));
					else if (map[nx][ny] =='X') next.offer(new Point(nx, ny));
					}
				}
			
				if(flag) break;
				
				swan = next;
				int waterSize = water.size();
				
				while(waterSize-->0) {
					Point po = water.poll();
					
					for(int d=0; d<4; d++) {
						int nx = po.x + dx[d];
						int ny = po.y + dy[d];
						
						if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
						if(map[nx][ny]=='X') {
							map[nx][ny] = '.';
							water.offer(new Point(nx, ny));
						}
					}
				}
				day++;
			}
			System.out.println(day);
		}
}