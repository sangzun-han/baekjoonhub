import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer =0;
      int maxCount = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : array) {
            int count = map.getOrDefault(i, 0) + 1;
            if (count > maxCount) {
                maxCount = count;
                answer = i;
            } else if(count ==maxCount) {
                answer = -1;
            }
            map.put(i,count);
        }

        return answer;
    }
}