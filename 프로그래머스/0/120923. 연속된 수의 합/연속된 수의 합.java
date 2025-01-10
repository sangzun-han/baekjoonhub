class Solution {
    public int[] solution(int num, int total) {
        
        int start = (total - num*(num-1)/2) / num;
        int[] answer = new int[num];
        int index = 0;
        for(int i=start; i<start+num; i++) {
            answer[index++] = i;
        }
        
        return answer;
    }
}