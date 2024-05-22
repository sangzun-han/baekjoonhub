import java.io.*;
import java.util.*;

class Solution {
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for(int i=0; i<operations.length; i++) {
            String[] s = operations[i].split(" ");
            
            if(s[0].equals("I")) {
                int num = Integer.parseInt(s[1]);
                maxQueue.offer(num);
                minQueue.offer(num);
            } else if(s[0].equals("D")) {
                int num = Integer.parseInt(s[1]);
                   if(num == 1 && !maxQueue.isEmpty()) {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                } else if(num == -1 && !minQueue.isEmpty()) {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                }
            }
        }
         if(maxQueue.isEmpty()) {
            answer[0] = 0;
        } else {
            answer[0] = maxQueue.peek();
        }

        if(minQueue.isEmpty()) {
            answer[1] = 0;
        } else {
            answer[1] = minQueue.peek();
        }
        
        return answer;
    }
}