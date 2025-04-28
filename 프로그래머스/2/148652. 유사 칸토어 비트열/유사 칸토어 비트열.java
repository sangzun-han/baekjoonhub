class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long num=l-1; num<r; num++) {
            if(recursive(num)) answer++;
        }
        return answer;
    }
    
    public boolean recursive(long num) {
        if(num%5==2) return false;
        if(num/5 ==0) return true;
    
        return recursive(num/5);
    }
}

