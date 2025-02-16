import java.util.*;

class Point {
    int out;
    int in;
    
    Point(int out, int in) {
        this.out = out;
        this.in = in;
    }
}

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Point> nodes = new HashMap<>();
        int[] answer = new int[4];
        int createNode = -1;
        int donut = 0;
        int stick = 0;
        int eight = 0;
        
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            
            if(!nodes.containsKey(from)) {
                nodes.put(from, new Point(0,0));
            }
            
            if(!nodes.containsKey(to)) {
                nodes.put(to, new Point(0,0));
            }
            
            nodes.get(from).out++;
            nodes.get(to).in++;
        }
        
        for(int key: nodes.keySet()) {
            Point p = nodes.get(key);
            
            // 나가는 간선 2개이상이며 들어오는게 없다면 새로운 정점
            if(p.out >= 2 && p.in == 0) {
                createNode = key;
            }
            
            // 나가는 거 없이, 들어오는거 1개면 막대그래프
            if(p.out == 0 && p.in > 0) {
                stick++;
            }
            
            // 2개이상 이면 8자
            if(p.out >= 2 && p.in >= 2) {
                eight++;
            }
        }
        
        donut = nodes.get(createNode).out - stick - eight;
        
        answer[0] = createNode;
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;
        
        return answer;
    }
}