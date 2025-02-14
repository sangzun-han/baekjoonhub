import java.util.*;
class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int N,M;
    static boolean[][] visited;
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        N = n;
        M = m;
        int[] answer = new int[2];
       
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[j][i] && picture[j][i] != 0) {
                    maxSizeOfOneArea = Math.max(bfs(j,i, picture, picture[j][i]), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    public int bfs(int r, int c, int[][] picture, int target) {
        Queue<Point> queue = new ArrayDeque<>();
        int count = 1;
        visited[r][c] = true;
        queue.offer(new Point(r,c));
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nr = p.x + dr[d];
                int nc = p.y + dc[d];
                
                if(nr>=0 && nr<M && nc>=0 && nc<N && !visited[nr][nc] && picture[nr][nc]==target) {
                    queue.offer(new Point(nr,nc));
                    visited[nr][nc] = true;
                    count++;
                }
            }
        }
    
        return count;
    }
}