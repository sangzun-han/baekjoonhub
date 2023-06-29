import java.util.*;

class Solution {
    public int[] solution(String s) {
       
        String[] strs = s.replaceAll("[{}]", " ").trim().split(" ,");
        int[] answer = new int[strs.length];
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(strs, (a,b) -> (a.length() - b.length()));
        int index = 0;
        for(String str: strs) {
            for(String x: str.split(",")) {
                int num = Integer.parseInt(x.trim());
                if(set.contains(num)) continue;
                set.add(num);
                answer[index++] = num;
            }
        }

        return answer;
    }
}