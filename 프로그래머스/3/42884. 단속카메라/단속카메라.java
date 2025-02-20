import java.util.*;

class Car implements Comparable<Car>{
    int in;
    int out;
    
    Car(int in, int out) {
        this.in = in;
        this.out = out;
    }
    
    @Override
    public int compareTo(Car c) {
        if(this.out == c.out) {
            return this.in - c.in;
        }
            
        return this.out - c.out;
    }
}

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<Car> pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int[] route: routes) {
            int in = route[0];
            int out = route[1];
            pq.offer(new Car(in, out));
        }
        
        while(!pq.isEmpty()) {
            Car car = pq.poll();
            answer++;
            while(!pq.isEmpty() && pq.peek().in <= car.out) {
                pq.poll();
            }
        }
        
        return answer;
    }
}