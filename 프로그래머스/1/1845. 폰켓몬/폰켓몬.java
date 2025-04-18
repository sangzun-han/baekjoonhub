import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        int size = nums.length / 2;
        int answer = 0;
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            int count = map.getOrDefault(num, 0);
            if(count > 0) set.add(num);
            if(set.size() == size) break;
        }
        
        
        
        return set.size();
    }
}