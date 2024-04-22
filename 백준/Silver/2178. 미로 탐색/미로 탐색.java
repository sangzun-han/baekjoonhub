

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String temp = (br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		bfs();
		System.out.println(map[N-1][M-1]);
	}

	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {0,0});
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = xy[0] + dx[d];
				int ny = xy[1] + dy[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 0) continue;
				visited[nx][ny] = true;
				queue.offer(new int[] {nx,ny});
				map[nx][ny] = map[xy[0]][xy[1]]+1;
				
				if(nx==N-1 && ny==M-1) return;
				
			}
		}
	}

//	private static void dfs(int x, int y, int count) {
//		if (x == N - 1 && y == M - 1) {
//			ans = Math.min(ans, count);
//			return;
//		}
//		for (int d = 0; d < 4; d++) {
//			int nx = x + dx[d];
//			int ny = y + dy[d];
//
//			if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
//				continue;
//
//			if (map[nx][ny]=='1') {
//				visited[nx][ny] = true;
//				dfs(nx, ny, count + 1);
//				visited[nx][ny] = false;
//			}
//
//		}
//
//	}
}
