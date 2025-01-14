import java.util.*;

class Process {
    int priority;
    int index;
    
    Process(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            queue.add(new Process(priorities[i], i));
        }
        
        while(!queue.isEmpty()) {
            Process process = queue.poll();
            boolean isHigher = false;
            
            for(Process p: queue) {
                if(process.priority < p.priority) {
                    isHigher = true;
                    break;
                }
            }
            
            if(isHigher) {
                queue.add(process);    
            } else {
                answer++;
                if(process.index == location) {
                    return answer;
                }
            }
            
        }
        
        return answer;
    }
}