import java.util.*;

class Solution {
    static int startX,startY;
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        visited = new boolean[N][M];
        map = new char[N][M];
        
        for(int i=0; i<N; i++) {
            char[] c = board[i].toCharArray();
            for(int j=0; j<M; j++) {
                map[i][j] = c[j];
                if(map[i][j]=='R') {
                    startX = i;
                    startY = j;
                }
            }
        }    
        
        return bfs(startX, startY);
    }
    
    public int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{x,y,0});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int time = cur[2];
            
            if(map[cx][cy]=='G') return time;
            
            for(int d=0; d<4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                while(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] != 'D') {
                    nx += dx[d];
                    ny += dy[d];
                }
                
                // 벽을 만났거나 D까지 와버린상태니 - 해준다.
                nx -= dx[d];
                ny -= dy[d];
                if(visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx,ny, time+1});
                
            }
        }   
        return -1;
    }
  
}