class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(0, numbers, target, 0);
        
        return answer;
    }
    
    public void dfs(int sum, int[] numbers, int target, int index) {
        if(index==numbers.length) {
            if(sum == target) answer++;   
            return;
        }
        
        dfs(sum + numbers[index], numbers, target, index+1);
        dfs(sum - numbers[index], numbers, target, index+1);

        
    }
}