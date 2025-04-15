class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a = findDivision(arrayA, arrayB);
        int b = findDivision(arrayB, arrayA);
        answer = Math.max(a,b);
        return answer;
    }
    
    public int GCD(int a, int b) {
        while(b!=0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        
        return a;
    }
    
    public int findDivision(int[] arrayA, int[] arrayB) {
        int gcd = arrayA[0];
        
        for(int i=1; i<arrayA.length; i++) {
            gcd = GCD(gcd, arrayA[i]);
        }
        
        for(int i=0; i<arrayB.length; i++) {
            if(arrayB[i] % gcd == 0) {
                return 0;
            }
        }
        
        return gcd;
    }
}