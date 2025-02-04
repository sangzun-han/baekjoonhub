class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int agcd = arrayA[0];
        int bgcd = arrayB[0];
        
        for(int i=1; i<arrayA.length; i++) {
            agcd = GCD(agcd, arrayA[i]);
        }
        
        for(int i=1; i<arrayB.length; i++) {
            bgcd = GCD(bgcd, arrayB[i]);
        }
        
        boolean adivide = true;
        boolean bdivide = true;
        
        boolean cdivide = true;
        boolean ddivide = true;
        
        // 철수가 가진 카드를 나눌수 있는지 없는지 판단
        // 철수꺼 나눌수 있어야함
        for(int i=0; i<arrayA.length; i++) {
            if(arrayA[i] % agcd != 0) {
                adivide = false;
                break;
            }
        }
        
        // 영희꺼는 나눌수없어야함
        for(int i=0; i<arrayB.length; i++) {
            if(arrayB[i] % agcd == 0) {
                bdivide = false;        
                break;
            }
        }
        
        for(int i=0; i<arrayA.length; i++) {
            if(arrayA[i] % bgcd == 0) {
                cdivide = false;
                break;
            }
        }
        
        // 영희꺼는 나눌수없어야함
        for(int i=0; i<arrayB.length; i++) {
            if(arrayB[i] % bgcd != 0) {
                ddivide = false;        
                break;
            }
        }
        
        if(adivide && bdivide) {
            answer = Math.max(agcd,answer);
        }  
        if(cdivide && ddivide) {
            answer = Math.max(bgcd,answer);
        }        
        
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
}