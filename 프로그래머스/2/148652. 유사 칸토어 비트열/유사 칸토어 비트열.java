class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i=l-1; i<r; i++) {
            if(isKantoa(i)) answer++;
        }
        return answer;
    }
    
    public boolean isKantoa(long x) {
        if(x < 5 && x != 2) return true;
        if(x % 5 == 2) return false;
        
        return isKantoa(x/5);
    }
}