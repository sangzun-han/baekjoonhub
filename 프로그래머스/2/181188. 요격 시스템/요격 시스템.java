import java.util.*;

class Target implements Comparable<Target>{
    int s;
    int e;
    
    Target(int s, int e) {
        this.s = s;
        this.e = e;
    }
    
    @Override
    public int compareTo(Target t) {
        if(e == t.e) return t.s - s;
        return e - t.e;
    }
}

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<Target> pq = new PriorityQueue<>();
        for(int i=0; i<targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];
            pq.offer(new Target(s,e));
        }
        
        while(!pq.isEmpty()) {
            Target t = pq.poll();
            while(!pq.isEmpty() && t.e > pq.peek().s) {
                pq.poll();
            }
            answer++;
        }
        
        return answer;
    }
}