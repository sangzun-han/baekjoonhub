class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        int min = 0;
        int maxW = 0;
        int maxH = 0;
        
        for(int i=0; i<sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            // w쪽에 큰거 몰빵
        
            max = Math.max(w, h); 
            min = Math.min(w, h);
            
            maxW = Math.max(max, maxW);
            maxH = Math.max(min, maxH);
            
        }
    
        return maxW * maxH;
    }
}
    