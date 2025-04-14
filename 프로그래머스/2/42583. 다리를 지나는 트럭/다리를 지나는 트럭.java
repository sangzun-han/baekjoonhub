import java.util.*;

class Truck {
    int weight;
    int time;
    
    Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> waiting = new ArrayDeque<>();
        Queue<Truck> bridge = new ArrayDeque<>();
        
        for(int i=0; i<truck_weights.length; i++) {
            waiting.offer(truck_weights[i]);
        }
        
        int time = 0;
        int totalWeight = 0;
        
        while(!waiting.isEmpty() || !bridge.isEmpty()) {
            time++;
            
            // 트럭 빼기
            if(!bridge.isEmpty() && time - bridge.peek().time >= bridge_length) {
                Truck truck = bridge.poll();
                totalWeight -= truck.weight;   
            }
            // 새로운 트럭 투입
           if(!waiting.isEmpty() && totalWeight + waiting.peek() <= weight) {
               int truckWeight = waiting.poll();
               totalWeight += truckWeight;
               bridge.offer(new Truck(truckWeight, time));
           }
        }
       
        return time;
    }
}



