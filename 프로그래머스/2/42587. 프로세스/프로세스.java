import java.util.*;

class Point {
    int index;
    int property;
    
    Point(int index, int property) {
        this.index = index;
        this.property = property;
        
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Point> queue = new ArrayDeque<>();
        int size = priorities.length;
        
        for(int i=0; i<size; i++) {
            queue.offer(new Point(i, priorities[i]));
        }
        
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            
            boolean isHigher = false;
            for(Point p: queue) {
                if(p.property > current.property) {
                    isHigher = true;
                    break;
                }
            }
            
            if(isHigher) {
                queue.offer(current);
            } else {
                answer++;
                if(current.index == location) {
                    return answer;
                }
            }
            
        }
        
        return answer;
    }
}
