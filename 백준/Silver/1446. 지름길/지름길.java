import java.io.*;
import java.util.*;

class Shorts {
    int start;
    int end;
    int dist;
    
    Shorts(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }
}

public class Main {
    static int N,D;
    static int answer = Integer.MAX_VALUE;
    static List<Shorts> shortsList = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
                
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if(end > D) continue; // 도착지보다 더 먼 곳 제외
            if(end - start < dist) continue; // 그냥 가는것보다 시간 오래걸리는거 제외
            
            shortsList.add(new Shorts(start, end, dist));
        }
        
        dfs(0, 0);
        System.out.println(answer);
    }
    
    public static void dfs(int v, int cost) {
        if(cost > D) return;
        
        if(v==D){
            answer = Math.min(answer, cost);
            return;
        };
        
        for(Shorts shorts: shortsList) {
            if(shorts.start == v) {
                dfs(shorts.end, cost + shorts.dist);
            }
        }
        
        dfs(v+1, cost+1);

    }
}
