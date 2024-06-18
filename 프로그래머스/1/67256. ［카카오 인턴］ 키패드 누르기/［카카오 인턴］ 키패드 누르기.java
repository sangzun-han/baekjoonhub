import java.util.*;

class Solution {
    static public class Location {
        int x,y;
        
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int distance(Location loc) {
            return Math.abs(this.x - loc.x) + Math.abs(this.y - loc.y);
        }
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        Map<Integer, Location> map = new HashMap<>();        
        map.put(1, new Location(0, 0));
        map.put(2, new Location(0, 1));
        map.put(3, new Location(0, 2));
        map.put(4, new Location(1, 0));
        map.put(5, new Location(1, 1));
        map.put(6, new Location(1, 2));
        map.put(7, new Location(2, 0));
        map.put(8, new Location(2, 1));
        map.put(9, new Location(2, 2));
        map.put(0, new Location(3, 1));
        map.put(-1, new Location(3, 0)); // * 
        map.put(-2, new Location(3, 2)); // # 
        
        Location left = map.get(-1);
        Location right = map.get(-2);
        
        for(int i=0; i<numbers.length; i++) {
            Location target = map.get(numbers[i]);
            
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) {
                answer += "L";
                left = target;
            } else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9) {
                answer += "R";
                right = target;
            } else {
                int leftDistance = left.distance(target);
                int rightDistance = right.distance(target);
                
                if(leftDistance < rightDistance) {
                    answer += "L";
                    left = target;
                } else if(leftDistance > rightDistance) {
                    answer += "R";
                    right = target;
                } else if(leftDistance == rightDistance) {
                    if(hand.equals("left")) {
                        answer += "L";
                        left = target;
                    } else if(hand.equals("right")) {
                        answer += "R";
                        right= target;
                    }
                }
            }
        }
        return answer;
    }
}

// 1 4 7 인 경우에는 왼쪽이 움직이고 클릭한다.
// 3 6 9 인 경우에는 오른쪽이 움직이고 클린한다.

// 2 5 8 0 인 경우에는 왼쪽, 오른쪽을 비교해서 가까운곳이 클릭한다.
// 만약 왼쪽, 오른쪽 거리가 같다면 주 '손'을 따라간다.