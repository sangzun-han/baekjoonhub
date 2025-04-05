class Solution {
    public long solution(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        
        long answer = 0;
        int[] d = new int[n+1];
        d[1] = 1;
        d[2] = 2;
        
        for(int i=3; i<=n ;i++) {
            d[i] = (d[i-2] + d[i-1])%1234567;
        }
        answer = d[n];
        return answer;
    }
}

// d[0] : 0
// d[1] : 1칸을 뛸때 도달할 수 있는 경우의 수 1
// d[2] : 2칸을 뛸때 도달할 수 있는 경우의 수 2
// d[3] : 3칸을 뛸때 도달할 수 있는 경우의 수 1 1 1 1 2 2 1