import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Point> list;
    static class Point implements Comparable<Point>{
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y =y;
        }

        @Override
        public int compareTo(Point p) {
            if(p.x==x) {
                return y - p.y;
            }
            return x-p.x;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 세로
        list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Point(x,y));
        }

        Collections.sort(list);




        int cnt = 0;


        for(Point p: list) {
            Point p1 = new Point(p.x+A, p.y+B);
            Point p2 = new Point(p.x+A, p.y);
            Point p3 = new Point(p.x, p.y+B);

            if(binarySearch(p1) && binarySearch(p2) && binarySearch(p3)) cnt++;

        }

        System.out.println(cnt);
    }

    public static boolean binarySearch(Point p) {
        int start = 0;
        int end = N;

        while(start+1<end) {
            int mid = (start+end)/2;

            Point cur = list.get(mid);

            if(p.x>cur.x || (p.x==cur.x && p.y>=cur.y)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(list.get(start).x==p.x && list.get(start).y ==p.y) return true;
        return false;
    }

}
