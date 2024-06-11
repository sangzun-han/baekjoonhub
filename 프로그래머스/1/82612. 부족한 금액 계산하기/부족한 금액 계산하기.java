class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long resultPrice = 0;
        
        for(int i=1; i<=count; i++) {
            resultPrice += price*i;
        }
        
        answer = resultPrice - money;
        
        return answer > 0 ? answer : 0;
    }
}
