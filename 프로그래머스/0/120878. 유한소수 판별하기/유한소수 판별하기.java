class Solution {
    public int solution(int a, int b) {
        //1. 최대공약수 구하기
        int gcd = GCD(a,b);
        int num = b/gcd;
        int answer = 1;
        
        while(num%2 == 0) {
            num /= 2;
        }
        while(num%5 == 0) {
            num/=5;
        }
        
        if(num != 1) {
            answer = 2;    
        }
        
        return answer;
    }
    
    private int GCD(int a, int b) {
        while(b!=0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}