class Solution {
    static int answer = Integer.MAX_VALUE;
    static int[][] table = {{1,1,1},{5,1,1,},{25,5,1}};
    public int solution(int[] picks, String[] minerals) {
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(minerals.length, totalPicks*5); // 최대 진행할수있는 횟수
        
        dfs(picks, minerals, 0, 0, maxMinerals);
        return answer;
    }
    
    public static void dfs(int[] picks, String[] minerals, int tired, int mineralIndex, int maxMinerals) {
        if(mineralIndex >= maxMinerals) {
            answer = Math.min(answer, tired);
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(picks[i] > 0) {
                picks[i]--;
                int newTired = tired;
                
                int remainMinerals = maxMinerals - mineralIndex; // 남은 광물 개수 만큼 캔다.
                int maxUse = Math.min(5, remainMinerals); // 5개까지만 가능
                
                for(int j=0; j<maxUse; j++) {
                    String mineral = minerals[mineralIndex + j];
                    
                    if(mineral.equals("diamond")) newTired += table[i][0];
                    else if(mineral.equals("iron")) newTired += table[i][1];
                    else if(mineral.equals("stone")) newTired += table[i][2];
                }
                
                dfs(picks, minerals, newTired, mineralIndex + maxUse, maxMinerals);
                picks[i]++;
            }
        }
        
    }
}