import java.util.*;
class Point {
    int num;
    int count;
    
    Point(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<Point> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[y+1];
        
        queue.offer(new Point(x, 0));
        visited[x] = true;
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.num == y) return p.count;
            
            int[] nextNums = {p.num + n, p.num * 2, p.num * 3};
            
            for (int next : nextNums) {
                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new Point(next, p.count + 1));
                }
            }
        }
        
        return answer;
    }
}