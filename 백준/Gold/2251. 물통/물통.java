import java.io.*;
import java.util.*;

public class Main {
    static int A,B,C;
    static List<Integer> list = new ArrayList<>();
    static class Point {
        int a,b,c;

        Point(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bfs();
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }

    private static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[201][201];
        queue.offer(new Point(0,0, C));
        while(!queue.isEmpty()) {
            Point p = queue.poll();

            if(visited[p.a][p.b]) continue;
            visited[p.a][p.b] = true;
            if(p.a==0) list.add(p.c);

            // a->b, a->c로 물 옮기기
            if(p.a+p.b > B) queue.offer(new Point(p.a+p.b - B, B, p.c));
            else queue.offer(new Point(0,p.a+p.b, p.c));

            if(p.a+p.c > C) queue.offer(new Point(p.a+p.c - C, B ,C));
            else queue.offer(new Point(0,p.b,p.a+p.c));

            // b->a b->c로 옮기기
            if(p.b+p.a > A) queue.offer(new Point(A, p.b+p.a-A, p.c));
            else queue.offer(new Point(p.b+p.a, 0, p.c));

            if(p.b+p.c > C) queue.offer(new Point(p.a+p.c - C, B ,C));
            else queue.offer(new Point(p.a,0,p.b+p.c));

            // c->a c->b
            if(p.a+p.c > A) queue.offer(new Point(A, p.b, p.c+p.a - A));
            else queue.offer(new Point(p.c+p.a, p.b,0));

            if(p.b+p.c > B) queue.offer(new Point(p.a, B, p.c+p.b-B));
            else queue.offer(new Point(p.a, p.c+p.b, 0));
         }
    }
}