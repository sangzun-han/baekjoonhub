import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
            char[] query = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            
            String s = br.readLine();
            s = s.substring(1, s.length()-1);  // [] 안 내용
            
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            String dir = "FRONT";
            
            if(n > 0) {
                String[] numsArray = s.split(",");
                for(int i=0; i<n; i++) {
                    queue.offer(Integer.parseInt(numsArray[i]));
                }
            }

            boolean error = false;

            for(char c : query) {
                if(c == 'R') {
                    if(dir.equals("FRONT")) dir = "BACK";
                    else dir = "FRONT";
                } else { 
                    if(queue.isEmpty()) {
                        sb.append("error\n");
                        error = true;
                        break;
                    }
                    
                    if(dir.equals("FRONT")) queue.pollFirst();
                    else queue.pollLast();
                }
            }

            if(error) continue;

            sb.append("[");
            if(!queue.isEmpty()) {
                if(dir.equals("FRONT")) {
                    while(!queue.isEmpty()) {
                        sb.append(queue.pollFirst());
                        if(!queue.isEmpty()) sb.append(",");
                    }
                } else {
                    while(!queue.isEmpty()) {
                        sb.append(queue.pollLast());
                        if(!queue.isEmpty()) sb.append(",");
                    }
                }
            }
            sb.append("]\n");
        }
        
        System.out.print(sb);
    }
}