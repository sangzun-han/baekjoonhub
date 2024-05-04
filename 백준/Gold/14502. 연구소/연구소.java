import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,ans;
	static int[][] map;
	static int[][] copyMap;
	static int[] dx= {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

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
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		ans = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		// 벽 3개 세우기
		dfs(0);
		System.out.println(ans);
		
	}
	private static void dfs(int cnt) {
		if(cnt==3) {
			// 벽 3개 세웠으면 바이러스 퍼트리기
			bfs();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfs(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	
	private static void bfs() {
		int result = 0;
		
		Queue<Point> queue = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copyMap[i][j] = map[i][j];
				if(copyMap[i][j]==2) queue.offer(new Point(i,j));
			}
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && copyMap[nx][ny]==0) {
					copyMap[nx][ny] = 2;
					queue.offer(new Point(nx,ny));
				}
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j]==0) result++;
			}
		}
		ans = Math.max(ans, result);
	}
	
}