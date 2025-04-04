class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n==3) return 2;
        if (n<=4) return 1;
        int left = 1;
        int right = 2;
        int sum = left + right;
        
        while(left < right || right < n) {
            if(sum<n) {
                right++;
                sum += right;
            } else if(sum>=n) {
                sum -= left;
                left++;
            }
            if(sum==n) {
                answer++;
            }
        }
        return answer;
    }
}

// 완탐 안될거같고, dp라 하기엔? 이전값 저장하는 방식이 아닌데.
// d[1] : 연속된 수를 이용하여 1을 만드는 경우의 수 = 1
// d[2] : 연속된 수를 이용하여 2를 만드는 경우의 수 = 1
// d[3] : 연속된 수를 이용하여 3을 만드는 경우의 수 = 1 

// 투포인터?