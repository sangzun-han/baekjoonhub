import java.util.*;

class Point {
    int x;
    int y;
    int time;
    
    Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Solution {
    static int N;
    static int M;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] map;
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        
        int startX = 0, startY = 0, leverX = 0, leverY = 0, endX = 0, endY = 0;
        for(int i=0; i<N; i++) {
            char[] c = maps[i].toCharArray();
            for(int j=0; j<M; j++) {
                map[i][j] = c[j];
                if(c[j]=='S') {
                    startX = i;
                    startY = j;
                } else if(c[j]=='L') {
                    leverX = i;
                    leverY = j;
                } else if(c[j]=='E') {
                    endX = i;
                    endY = j;
                }
            }
        }
        
        int minLever = bfs(startX, startY, leverX, leverY);
        int minExit = bfs(leverX, leverY, endX, endY);
        
        if(minLever==0|| minExit==0) {
            return -1;
        } else {
            answer = minLever + minExit;
        }
        
        return answer;
    }
    
    public static int bfs(int x1, int y1, int x2, int y2) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        visited[x1][y1] = true;
        queue.offer(new Point(x1,y1,0));

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            for(int d=0; d<4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                int time = p.time;
                if(nx==x2 && ny==y2) {
                    return time+1;
                }
                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]) {
                    if(map[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny, time+1));     
                    }           
                }
            }
        }
        
        return 0;
    }
    
}