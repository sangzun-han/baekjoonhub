
import java.io.*;
import java.util.*;

public class Main {
    static class Coordinate {
        int x,y;

        Coordinate(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Map<Character, Coordinate> map;
    public static void main(String[] args) throws Exception{
        map = new HashMap<>();
        map.put('q',new Coordinate(1,1));
        map.put('w',new Coordinate(1,2));
        map.put('e',new Coordinate(1,3));
        map.put('r',new Coordinate(1,4));
        map.put('t',new Coordinate(1,5));
        map.put('y',new Coordinate(1,6));
        map.put('u',new Coordinate(1,7));
        map.put('i',new Coordinate(1,8));
        map.put('o',new Coordinate(1,9));
        map.put('p',new Coordinate(1,10));
        map.put('a',new Coordinate(2,1));
        map.put('s',new Coordinate(2,2));
        map.put('d',new Coordinate(2,3));
        map.put('f',new Coordinate(2,4));
        map.put('g',new Coordinate(2,5));
        map.put('h',new Coordinate(2,6));
        map.put('j',new Coordinate(2,7));
        map.put('k',new Coordinate(2,8));
        map.put('l',new Coordinate(2,9));
        map.put('z',new Coordinate(3,1));
        map.put('x',new Coordinate(3,2));
        map.put('c',new Coordinate(3,3));
        map.put('v',new Coordinate(3,4));
        map.put('b',new Coordinate(3,5));
        map.put('n',new Coordinate(3,6));
        map.put('m',new Coordinate(3,7));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char sl = st.nextToken().charAt(0);
        char sr = st.nextToken().charAt(0);

        char[] str = br.readLine().toCharArray();
        String right = "qwertasdfgzxcv";
        String left = "yuiophjklbnm";
        int ans = 0;
        for(int i=0; i<str.length; i++) {
            char c = str[i];
            // 오른쪽 손가락으로 이동해야함.
            if(right.contains(String.valueOf(c))) {
                Coordinate coor = map.get(sl);
                Coordinate coor1 = map.get(c);
                int dist = Math.abs(coor.x - coor1.x) + Math.abs(coor.y - coor1.y) + 1;
                ans += dist;
                sl = c;
            } else if(left.contains(String.valueOf(c))) {
                Coordinate coor = map.get(sr);
                Coordinate coor1 = map.get(c);
                int dist = Math.abs(coor.x - coor1.x) + Math.abs(coor.y - coor1.y) + 1;
                ans += dist;
                sr = c;
            }

        }

        System.out.println(ans);
    }

}
