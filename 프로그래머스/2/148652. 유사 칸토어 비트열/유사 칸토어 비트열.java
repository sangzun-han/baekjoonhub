class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i=l-1; i<r; i++) {
            if(recursive(i)) answer++;
        }
        return answer;
    }
    
    public boolean recursive(long n) {
        if(n==0) return true;
        if(n%5==2) return false;
        
        return recursive(n/5);
      
    }
}