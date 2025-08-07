import java.io.*;
import java.util.*;

class Point {
    int x,y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        List<Point> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x,y));
        }
        
        // 정렬은 되서 주어짐
        
        for(Point p: list) {
            int x = p.x;
            int y = p.y;
            
            while(!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                answer++;
            }
            
            if((stack.isEmpty() || stack.peek() != y) && y!=0) {
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
