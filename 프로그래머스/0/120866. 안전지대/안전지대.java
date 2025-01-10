class Solution {
    static int[][] map;
    static int[] dx = {0,0,-1,1,-1,1,-1,1};
    static int[] dy = {-1,1,0,0,-1,1,1,-1};
    static boolean[][] visited;
    
    public int solution(int[][] board) {
        int answer = 0;
        map = board;
        int size = board.length;
        visited = new boolean[size][size];
        
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(map[i][j]==1 && !visited[i][j]) check(i,j,size);
            }
        }
        
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(map[i][j]==0) answer++;
            }
        }
        
        return answer;
    }
    
    private void check(int x, int y, int size) {
        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 &&  nx<size && ny>=0 && ny<size && !visited[nx][ny] && map[nx][ny] != 1) {
                visited[nx][ny] = true;
                map[nx][ny] = 1;
            }
        }
    }
}