import java.util.*;

class Point {
    int r;
    int c;
    
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    static char[][] storages;
    static int n,m;
    static List<Point> deleteList = new ArrayList<>();
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        
        storages = new char[n][m];
        
        for(int i=0; i<n; i++) {
            storages[i] = storage[i].toCharArray();
        }
        
        for(int k=0; k<requests.length; k++) {
            String request = requests[k];
            // bfs돌던가, 외부와 연결됐던가
            // 삭제할 수 있는거 다 모아서 한꺼번에 삭제.

            if(request.length()==1) {
                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {    
                        if(request.charAt(0) == storages[i][j]) {
                            if(canEscape(i,j) ||isOut(i, j)) {
                                deleteList.add(new Point(i,j));
                            }
                        }
                    }
                }
                
                for(Point p: deleteList) {
                    storages[p.r][p.c] = '.';
                }
                
                deleteList.clear();
            }
            else {
                for(int i=0; i<n; i++) {
                    for(int j=0; j<m; j++) {
                        if(storages[i][j]==request.charAt(0)) {
                            storages[i][j] = '.';
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(storages[i][j]!='.') answer++;
            }
        }
        
        
        return answer;
    }
    
    public boolean isOut(int r, int c) {
        return (r==n-1 || r==0 || c==m-1 || c==0);
    }
    
    public boolean canEscape(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new Point(r,c));
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            
            if(isOut(p.r, p.c)) return true;
            
            for(int d=0; d<4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && storages[nr][nc] == '.') {
                    queue.offer(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return false;
    }
}
