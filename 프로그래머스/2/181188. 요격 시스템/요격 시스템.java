import java.util.*;

class Point implements Comparable<Point>{
    int s;
    int e;
    
    Point(int s, int e) {
        this.s = s;
        this.e = e;
    }
    
    @Override
    public int compareTo(Point p) {
        if(this.e == p.e) return this.s - p.e;
        return this.e - p.e;
    }
}

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for(int[] target: targets) {
            int s = target[0];
            int e = target[1];
            pq.offer(new Point(s,e));
        }
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            
            while(!pq.isEmpty() && pq.peek().s < p.e) {
                pq.poll();
            }
            answer++;
        }
        
        return answer;
    }
}