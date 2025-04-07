class Solution {
     public int solution(int[] citations) {
        int answer = 0;
        for (int h = 0; h <= 1000; h++) {
            int count = 0;
            for (int citation : citations) {
                if (citation >= h) {
                    count++;
                }
            }
            if (count >= h) {
                answer = Math.max(answer, h);
            }
        }
        return answer;
    }
}


// n편의 논문중 3번이상 인용된 논문이 3편이상 나머지 논문이 3편이하.
// “h번 이상 인용된 논문이 h편 이상” h개 이상을 찾으면 어차피 알아서 h개 이하는 만족한다.
