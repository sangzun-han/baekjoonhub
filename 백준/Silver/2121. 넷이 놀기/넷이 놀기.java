import java.io.*;
import java.util.*;

public class Main {
    static class Point {

        final int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true; // 같은 객체 참조하여 참조값 같은 경우
            if(obj==null || getClass() != obj.getClass()) return true; // 비교하는 객체가 Null인지 클래스가 같은지 체크
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<Point> hash = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 세로

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            hash.add(new Point(x,y));
        }

        int cnt = 0;

        for(Point p: hash) {
            Point p1 = new Point(p.x+A, p.y);
            Point p2 = new Point(p.x+A, p.y+B);
            Point p3 = new Point(p.x, p.y+B);

            if(hash.contains(p1) && hash.contains(p2) && hash.contains(p3)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
