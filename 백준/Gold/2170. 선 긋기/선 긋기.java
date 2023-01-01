import java.io.*;
import java.util.*;
public class Main {
    static class Line implements Comparable<Line>{
        int x,y;
        Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Line> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Line(x,y));
        }

        Collections.sort(list);

        int ans = 0;

        int prevX = list.get(0).x;
        int prevY = list.get(0).y;
        ans = prevY - prevX;

        for(int i=1; i<N; i++) {
            // 1. 포함된다
            if(prevX <= list.get(i).x && prevY >= list.get(i).y) continue;
            // 2. 겹친다.
            else if(prevY > list.get(i).x) ans+= Math.abs(prevY - list.get(i).y);
            // 3. 겹치지 않는다.
            else ans += Math.abs(list.get(i).y - list.get(i).x);
            prevX = list.get(i).x;
            prevY = list.get(i).y;
        }

        System.out.println(ans);

    }

}