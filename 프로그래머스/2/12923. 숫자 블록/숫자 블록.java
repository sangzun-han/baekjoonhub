class Solution {
    public int[] solution(long begin, long end) {
        int size = (int) (end - begin) + 1;
        int[] answer = new int[size];
        
        for(int i=0; i<size; i++) {
            int num = (int) (begin + i);
            answer[i] = getMaxDivision(num);
        }
        return answer;
    }
    
    public int getMaxDivision(int num) {
 
        if(num==1) return 0;
        int max = 1;
        
        for(int i=2; i<=(int) Math.sqrt(num); i++) {
            if(num % i == 0) { // i가 약수라면 , num/i도 약수
                int pair = num / i; // num / i도 약수
                if (pair <= 10000000) return pair;
                max = i;
            }
        }
        
        return max;
    }
}