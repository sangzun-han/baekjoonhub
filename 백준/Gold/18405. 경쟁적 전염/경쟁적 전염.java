import java.io.*;
import java.util.*;

class Virus implements Comparable<Virus>{
    int r,c,num;
    
    Virus(int r, int c, int num) {
        this.r = r;
        this.c = c;
        this.num = num;
    }
    
    @Override
    public int compareTo(Virus v) {
        return this.num - v.num;
    }
}

public class Main {
    static int N,K;
    static int[][] map;
    static int S,X,Y;
    
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Virus> queue = new ArrayDeque<>();
        List<Virus> list = new ArrayList<>();
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j]!=0) {
                    list.add(new Virus(i,j, map[i][j]));
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int time = 0;
        
        Collections.sort(list);
        
        for(Virus v: list) queue.offer(new Virus(v.r, v.c, v.num));
        
       
        
        while(true) {
            if(time==S) break;
            
            int size = queue.size();  
               
            for(int i=0; i<size; i++) {
                Virus v = queue.poll();
            
                for(int d=0; d<4; d++) {
                    int nr = v.r + dr[d];
                    int nc = v.c + dc[d];
                    
                    if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc]==0) {
                        queue.offer(new Virus(nr,nc, v.num));
                        map[nr][nc] = v.num;
                    }
                }
            }
            time++;
        }
        
        
        System.out.println(map[X-1][Y-1]);
    }
}
