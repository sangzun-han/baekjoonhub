class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = sequence[0];
        
        while(right < sequence.length) {
            if(sum < k) {
                if(right < sequence.length - 1) {
                    right++;
                    sum += sequence[right];
                } else {
                    break;
                }

            }
            else if (sum > k) {
                sum -= sequence[left];
                left++;
                if(left > right) right = left;
            }
            else if(sum==k) {
                if(right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left];
                left++;
                if(left > right) right = left;
                
            }
        }
        return answer;
    }
}