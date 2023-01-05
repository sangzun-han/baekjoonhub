import java.io.*;
import java.util.*;
public class Main {
    static class Point implements Comparable<Point>{
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         int N = Integer.parseInt(st.nextToken());
         int L = Integer.parseInt(st.nextToken());

         ArrayList<Point> list = new ArrayList<>();

         for(int i=0; i<N; i++) {
             st = new StringTokenizer(br.readLine());
             int x = Integer.parseInt(st.nextToken());
             int y = Integer.parseInt(st.nextToken());
             list.add(new Point(x,y));
         }

         Collections.sort(list);

         int ans = 0;
         int start = 0;
         for(int i=0; i<list.size(); i++) {
             if(start < list.get(i).x) {
                 start = list.get(i).x;
             }

             if(list.get(i).y >= start) {
                 while(list.get(i).y > start) {
                     start += L;
                     ans++;
                 }
             }

         }
        System.out.println(ans);


    }
}