class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int diff = Integer.MAX_VALUE;
        int sum = sequence[left];
        
        while(right < sequence.length) {
            if(sum < k) {
                if(++right < sequence.length)
                sum += sequence[right];
            } else if (sum > k) {
                sum -= sequence[left++];
            } else if (sum == k) {
                if(right-left < diff) {
                    diff = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                
                sum -= sequence[left++];
            }
            
            if(left > right) {
                int temp = right;
                right = left;
                left = temp;
            }
        }
        
        return answer;
    }
}

// 투포인터
// target이 k
// sequence  0부터 시작,
// 만약 타겟이면 가장 짧은 길이 인지 체크 짧다면 체크;
// 만약 타겟보다 작으면 left 증가
// 만약 타겟보다 크다면 right 증가
// right < left 보다 커지는 경우가 있다면 교체 -> 이런 경우 존재하는지 모르겠음
// right가 n까지 도달했을때 종료