class Solution {
    
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0,0);   
        return answer;
    }
    
    public static int dfs(int[] numbers, int target, int size, int sum) {
        int ans = 0;
        if(numbers.length==size) {
            if(target==sum) return 1;
            return 0;
        }
        
        ans += dfs(numbers, target, size+1, sum-numbers[size]);
        ans += dfs(numbers, target, size+1, sum+numbers[size]);
        
        return ans;
    }
}
