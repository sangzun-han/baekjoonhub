class Solution {
    
    public int solution(int n, int k) {
    
        int answer = 0;
        String[] s = Integer.toString(n, k).split("0");
        
        for(int i=0; i<s.length; i++) {
            if(s[i].equals("")) continue;
            long number = Long.parseLong(s[i]);
            if(isPrime(number)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(long n) {
        if(n==0 || n==1) return false;
        for(int i=2; i<=(int)Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        
        return true;
    }
}