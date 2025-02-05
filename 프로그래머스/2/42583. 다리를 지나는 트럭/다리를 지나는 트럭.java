import java.util.*;

class Truck {
    int weight;
    int time;
    
    Truck(int weight, int time) {
        this.weight = weight;
        this.time = time; // 다리 다 건너는 시간
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Truck> bridge = new ArrayDeque<>();
        
        for(int i=0; i<truck_weights.length; i++) {
            queue.offer(truck_weights[i]);
        }
        
        int time = 0;
        int bridge_weight = 0;
        
        while(!queue.isEmpty() || !bridge.isEmpty()) {
            time++;
            // 1. 다리를 지나간 트럭 제거
            if(!bridge.isEmpty() && bridge.peek().time == time) {
                Truck truck =bridge.poll();
                bridge_weight -= truck.weight;
            }
            
            // 2. 다리에 올라갈 트럭 적재
            if(!queue.isEmpty() && bridge_weight + queue.peek() <= weight) {
                int w = queue.poll();
                bridge.offer(new Truck(w, time + bridge_length));
                bridge_weight += w;
            }

        }
        return time;
    }
}