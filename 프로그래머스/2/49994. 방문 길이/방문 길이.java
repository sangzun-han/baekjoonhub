import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        Set<String> set = new HashSet<>();
        
        String directions = "UDRL";
        int x = 0;
        int y = 0;
        for(char dir: dirs.toCharArray()) {
            int index = directions.indexOf(dir);
            int nx = x + dx[index];
            int ny = y + dy[index];
            
            if(nx<-5 || nx>5 || ny<-5 || ny>5) continue;
            
            String path = x+" "+y +"->"+nx+" "+ny;
            String reversePath = nx+" "+ny +"->"+x+" "+y;
            set.add(path);
            set.add(reversePath);
            
            x = nx;
            y = ny;
        }

        return set.size()/2;
    }
}