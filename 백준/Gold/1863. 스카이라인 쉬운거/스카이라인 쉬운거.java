import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x,y));
        }
        
        Collections.sort(list);
    
        for(Point p: list) {
            int x = p.x;
            int y = p.y;
            while(!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                answer++;
            }
            
            if ((stack.isEmpty() || stack.peek() != y) && y != 0) {
                stack.push(y);
            }        
        }
        
        while(!stack.isEmpty()) {
            stack.pop();
            answer++;
        }
        
        System.out.println(answer);
    }
}
