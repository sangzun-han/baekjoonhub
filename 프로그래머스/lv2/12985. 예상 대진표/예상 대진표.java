class Solution {
    static int A=0;
    static int B=0;
    
    public int solution(int n, int a, int b) {
        A = a;
        B = b;
        
        int answer = 1;
        
        while(Math.abs(B-A)!=1 || Math.max(A,B)%2==1) {
           
            A = A % 2 == 0 ? A/2 : A/2+1;
            B = B % 2 == 0 ? B/2 : B/2+1;
            answer++;
        }

        return answer;
    }
}