import java.util.*;

class Solution {
    static int size;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        int answer = 0;
        size = elements.length;
        int[] extended = new int[size * 2];
        
        for (int i = 0; i < size * 2; i++) {
            extended[i] = elements[i % size];
        }
    
        for (int len = 1; len <= size; len++) {
            for (int start = 0; start < size; start++) {
                int sum = 0;
                for (int k = 0; k < len; k++) {
                    sum += extended[start + k];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
    
}

