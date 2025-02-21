class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 0;
        
        for(int i=0; i<n; i++) {
            if(index < stations.length && i >= stations[index] - w - 1) {
                i = stations[index] + w - 1;
                index++;
            } else {
                answer++;
                i += w * 2;
            }
        }

        return answer;
    }
}