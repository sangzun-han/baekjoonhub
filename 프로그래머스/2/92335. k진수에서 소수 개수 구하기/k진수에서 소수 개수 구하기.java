class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n,k);
        String[] possiblePrime = number.split("0");
        
        for(int i=0; i<possiblePrime.length; i++) {
            String num = possiblePrime[i];
            if(num.equals("")) continue;
            if(isPrime(num)) answer++;
        }

        return answer;
    }
    
    public boolean isPrime(String num) {
        long number = Long.parseLong(num);
        
        if(number < 2) return false;
        if(number == 2) return true;
        if(number % 2 == 0) return false;
        
        for(int i=3; i<=(int) Math.sqrt(number); i++) {
            if(number%i==0) return false;
        }
        
        return true;
    }
    
  
}