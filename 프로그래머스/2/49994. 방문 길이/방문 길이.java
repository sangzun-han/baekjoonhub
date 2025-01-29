import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        String[] dir = dirs.split("");
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        
        int nx = 0;
        int ny = 0;
        
        for(String d: dir) {
          
            if(d.equals("U")) {
                nx = x+1;
                ny = y;
            }                
            else if(d.equals("D")) {
                nx = x-1;
                ny = y;
            }
            else if(d.equals("R")) {
                nx = x;
                ny = y+1;
            }
            else if(d.equals("L")) {
                nx = x;
                ny = y-1;
            }
            
            if(nx<-5 || nx>5 || ny<-5 || ny>5) continue;
            String path = x+" "+y+ " -> "+nx+" "+ny;
            String reversePath = nx+" "+ny+ " -> "+x+" "+y;
            set.add(path);
            set.add(reversePath);
            
            System.out.println(path);
            x = nx;
            y = ny;
        }
        
        return set.size()/2;
    }
}

// 1. U,D,R,L 4방향 이동
// 5,5(에서 시작), (5,5), (0,10) (0,0), (10,10)
