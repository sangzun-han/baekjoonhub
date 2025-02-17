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
    static Map<Integer, Integer> visited = new HashMap<>();
    
    public int solution(int x, int y, int n) {
        return bfs(x,y,n);
    }
    
    public int bfs(int x, int y, int n) {
        if(x==y) return 0;
        
        Queue<Point> queue = new ArrayDeque<>();
        visited.put(x, 0);
        queue.offer(new Point(x, 0));
        
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int[] nextNums = {p.num + n, p.num * 2, p.num * 3};
            
            for(int next: nextNums) {
                if(next > y) continue;
                if (visited.containsKey(next) && visited.get(next) <= p.count + 1) continue;
                if(next==y) return p.count + 1;
                queue.offer(new Point(next, p.count + 1));
                visited.put(next, p.count + 1);
            }
        }
        
        return -1;
    }
}