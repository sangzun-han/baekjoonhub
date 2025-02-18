class Solution {
    static int[] result = {-1};
    static int maxDiff = 0;
    
    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        
        backtracking(info, ryan, n, 0);
        return result;
    }
    
    public void backtracking(int[] apeach, int[] ryan, int n, int index) {
        if(n==0 || index==11) {
            if(index < 11) {
                for(int i=index; i<11; i++) ryan[i] = 0;
            }
            if(n > 0) ryan[10] = n; 
            calc(apeach, ryan);
            return;
        }
        
        // 다음거 쏘러감.
        backtracking(apeach, ryan, n, index + 1);
        
        // 어피치보다 한발 더 쏠수있으면 더 쏨
        if(n > apeach[index]) {
            ryan[index] = apeach[index] + 1;
            backtracking(apeach, ryan, n-ryan[index], index+1);
            ryan[index] = 0;
        }
        
    }
    
    public void calc(int[] apeach, int[] ryan) {
        int ryanScore = 0;
        int apeachScore = 0;
        
        for(int i=0; i<11; i++) {
            if(apeach[i] == 0 && ryan[i] == 0) continue;
            if(apeach[i] >= ryan[i]) apeachScore += 10-i;
            if(apeach[i] < ryan[i]) ryanScore += 10-i;
        }
        
        int diff = ryanScore - apeachScore;
        
        if(diff <= 0) return;
            
        // 라이언이 이김
        if(diff > maxDiff) {
            maxDiff = diff;
            result = ryan.clone();
        } else if(diff == maxDiff) {
            for(int i=10; i>=0; i--) {
                if(result.length==1) {
                    result = ryan.clone();
                    break;
                }
                if(result[i] < ryan[i]) {
                    result = ryan.clone();
                    break;
                } else if(result[i] > ryan[i]) {
                    break;
                }
            }
        }
    }
    
}