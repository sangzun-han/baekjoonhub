class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (int x = 0; x <= d; x += k) {
            int maxY = (int) Math.sqrt((long) d * d - (long) x * x); // 가능한 y의 최대값
            long countY = (maxY / k) + 1; 

            answer += countY;
        }

        return answer;
    }
}
