class Solution {
    static int[][] Dungeons;
    static boolean[] visited;
    static int maxDungeons = 0;
    
    public int solution(int k, int[][] dungeons) {
        Dungeons = dungeons;
        visited = new boolean[Dungeons.length];
        dfs(k, 0);
        
        return maxDungeons;
    }
    
    private static void dfs(int k, int count) {
        maxDungeons = Math.max(maxDungeons, count);
        
        for(int i=0; i<Dungeons.length; i++) {
            if(!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;
                dfs(k - Dungeons[i][1], count +1);
                visited[i] = false;
            }
        }
    }
}