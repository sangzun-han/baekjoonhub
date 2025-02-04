class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int N = n;
        
        while(N>0) {
            if(N%3!=0) {
                sb.append(N%3);
                N = N / 3;
            } else {
                sb.append(4);
                N = N / 3 - 1;
            }
        }
        return sb.reverse().toString();
    }
   
}



