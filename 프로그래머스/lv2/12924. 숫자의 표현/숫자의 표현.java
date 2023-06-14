class Solution {
    public int solution(int n) {
       
        int answer = 1;
        if(n<3) return answer;
        if(n==3) return 2;
        int left = 0;
        int right = 1;
        int[] num = new int[n/2+2];
        
        for(int i=1; i<=n/2+1; i++) {
            num[i] = i;
        }
        
        int sum = num[left] + num[right];
        
        while(true) {
            if(right==n/2+1 && left==right-1) {
                if(num[right]+num[left]==n) {
                    answer++;
                    break;
                } else {
                    break;
                }
            }
            if(sum < n) {
                right++;
                sum += num[right];
            } else if (sum > n) {
                sum -= num[left];
                left++;
            } else if(sum==n) {
                answer++;
                if(right==n/2+1) {
                    right = n/2+1;
                } else {
                    right++;
                    sum += num[right];
                }
            }
        }
       
        return answer;
    }
}