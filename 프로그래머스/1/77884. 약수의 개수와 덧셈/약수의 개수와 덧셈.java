class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
            boolean even = count(i);
            if(even) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }

    public boolean count(int num) {
        int cnt = 0;
        for(int i=1; i<=num; i++) {
            if(num%i==0) {
                cnt++;
            }
        }
        
        return cnt%2==0 ? true : false;
    }
}

    
    