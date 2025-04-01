import java.util.*;

class Point {
    int cur;
    int prev;
    int next;
    
    Point(int cur, int prev, int next) {
        this.cur = cur;
        this.prev = prev;
        this.next = next;
    }
}

class Solution {
    
    static int current;
    static int[] prev;
    static int[] next;
    static Stack<Point> stack;
    static boolean[] isDeleted;
    
    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        stack = new Stack<>();
        current = k;
        prev = new int[n];
        next = new int[n];
        isDeleted = new boolean[n];
        
        for(int i=0; i<n; i++) {
            prev[i] = i-1;
            next[i] = i+1;
        }
        next[n-1] = -1;
        
        for(int i=0; i<cmd.length; i++) {
            String[] cmdSplit = cmd[i].split(" ");
            // 삭제 or 복구
            if(cmdSplit.length==1) {
                String command = cmdSplit[0];
                if(command.equals("C")) {
                    delete();
                } else if(command.equals("Z")) {
                    restore();
                }
            } else if(cmdSplit.length==2) {
                String dir = cmdSplit[0];
                int number = Integer.parseInt(cmdSplit[1]);
                
                move(dir, number);
            }
        }
        
        for (Point p : stack) {
            isDeleted[p.cur] = true;
        }
        
        for(int i=0; i<n; i++) {
            if(isDeleted[i]) sb.append("X");
            else sb.append("O");
        }
        
        return sb.toString();
        
    }
    
    public void delete() {
        stack.push(new Point(current, prev[current], next[current]));

        if(prev[current]!=-1) next[prev[current]] = next[current];
        if(next[current]!=-1) prev[next[current]] = prev[current];
     
        if(next[current] != -1) current = next[current];
        else current = prev[current];
    }
    
    public void restore() {
        Point p = stack.pop();
        if(p.prev != -1) next[p.prev] = p.cur;
        if(p.next != -1) prev[p.next] = p.cur;
        
        prev[p.cur] = p.prev;
        next[p.cur] = p.next;
    }
    
    public void move(String dir, int number) {
        // 삭제된 행은 포함하면 안된다.
        if(dir.equals("D")) {
            for(int i=0; i<number; i++) {
                current = next[current];
            }
        } else if(dir.equals("U")) {
            for(int i=0; i<number; i++) {
                current = prev[current];
            }
        }
    }
    
}