import java.util.*;

class Dungeon {
    int 최소필요피로도;
    int 소모피로도;
    
    Dungeon(int 최소필요피로도, int 소모피로도) {
        this.최소필요피로도 = 최소필요피로도;
        this.소모피로도 = 소모피로도;
    }
}

class Solution {
    static List<Dungeon> dungeonList = new ArrayList<>();
    static boolean[] visited;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        int K = k;
        visited = new boolean[dungeons.length];
        answer = -1;
        
        perm(dungeons, 0, K);
   
        return answer;
    }
    
    public void perm(int[][] dungeons, int depth, int K) {
        if(depth==dungeons.length) {
            answer = Math.max(calc(K),answer);
            return;
        }
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i]) {
                int 최소필요피로도 = dungeons[i][0];
                int 소모피로도 = dungeons[i][1];
                dungeonList.add(new Dungeon(최소필요피로도, 소모피로도));
                visited[i] = true;
                perm(dungeons, depth+1, K);
                dungeonList.remove(dungeonList.size()-1);
                visited[i] = false;
            }
        }
    }
    
    public int calc(int k) {
        int count = 0;
        for(Dungeon dungeon: dungeonList) {
            int 최소필요피로도 = dungeon.최소필요피로도;
            int 소모피로도 = dungeon.소모피로도;
            
            if(k >= 최소필요피로도) {
                k -= 소모피로도;
                count++;
            }
        }
        
        return count;
    }
}