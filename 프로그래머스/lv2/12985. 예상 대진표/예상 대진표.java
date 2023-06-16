class Solution {
    static int N = 0;
    static int A = 0;
    static int B = 0;
    public int solution(int n, int a, int b) {
        int answer = 0;
        int N = n;
        int A = a;
        int B = b;
        while(Math.abs(A-B)!=1 || Math.max(A,B)%2==1) {
            answer++;
            if(A%2==0)  A = A/2;
            else if(A%2==1) A = A/2+1;
            if(B%2==0) B = B/2;
            else if(B%2==1) B = B/2+1;
        }
        
        return answer+1;
    }
}