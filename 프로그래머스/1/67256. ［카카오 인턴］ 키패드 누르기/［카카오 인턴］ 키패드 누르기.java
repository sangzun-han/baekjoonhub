import java.util.*;

class Location {
    int x;
    int y;
    
    Location(int x,int y) {
        this.x = x;
        this.y = y;
    }
    
    public int distance(Location loc) {
        return Math.abs(this.x-loc.x) + Math.abs(this.y - loc.y);
    }
}
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Location> map = new HashMap<>();
     
        map.put(1, new Location(0,0));
        map.put(2, new Location(0,1));
        map.put(3, new Location(0,2));
        map.put(4, new Location(1,0));
        map.put(5, new Location(1,1));
        map.put(6, new Location(1,2));
        map.put(7, new Location(2,0));
        map.put(8, new Location(2,1));
        map.put(9, new Location(2,2));
        map.put(0, new Location(3,1));
        map.put(-1, new Location(3,0));
        map.put(-2, new Location(3,2));
        
        Location locLeft = map.get(-1);
        Location locRight = map.get(-2);
        
        for(int num: numbers) {
            Location loc = map.get(num);
            // 왼쪽손
            if(num==1 || num==4 || num==7) {
                sb.append("L");
                locLeft = loc;
            }
            // 오른손
            else if(num==3 || num==6 || num==9) {
                sb.append("R");
                locRight = loc;
            }
            // 거리계산
            else if (num==2 || num==5 || num==8 || num==0) {
                int leftDis = locLeft.distance(loc);
                int rightDis = locRight.distance(loc);
                
                if(leftDis > rightDis) {
                    sb.append("R");
                    locRight = loc;
                }
                else if(leftDis < rightDis) {
                    sb.append("L");
                    locLeft = loc;
                }
                else if(leftDis==rightDis) {
                    if(hand.equals("right")) {
                        sb.append("R");
                        locRight = loc;
                    } else {
                        sb.append("L");
                        locLeft = loc;
                    }
                }
                
            }
        }
        return sb.toString();
    }
}