class Solution {
    static int answer;
    
    public int solution(int storey) {
        answer = 100;
        dfs(storey, 0);
        return answer;
    }
    
    public void dfs(int storey, int count) {
        if(count > answer) return;
        
        if(storey==0) {
            answer= Math.min(count,answer);
            return;
        }
        
        int remain = storey % 10;
        
        // if(remain==0) {
        //     dfs(storey/10, count);
        //     return;
        // }
        
        int next1 = storey + (10 - remain);
        int next2 = storey - remain;
        
        dfs(next1/10, count+(10-remain));
        dfs(next2/10, count+remain);
        
    }
}
