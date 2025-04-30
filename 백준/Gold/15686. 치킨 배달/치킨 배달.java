import java.io.*;
import java.util.*;

class Point {
    int r;
    int c;
    
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N,M;
    static int[][] maps;
    static List<Point> selected = new ArrayList<>();
    static List<Point> homes = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if(maps[i][j]==1) homes.add(new Point(i,j));
                if(maps[i][j]==2) chickens.add(new Point(i,j));
            }
        }
        comb(0, 0);
        System.out.println(answer);
    }
    
    public static void comb(int count, int index) {
        if(count == M) {
            answer = Math.min(answer, getChickenDistance());
            return;
        }
        
        for(int i=index; i<chickens.size(); i++) {
            Point chicken = chickens.get(i);
            selected.add(new Point(chicken.r, chicken.c));
            comb(count+1, i+1);
            selected.remove(selected.size() - 1);
        }
        
     
    }
    
    public static int getChickenDistance() {
        int sum = 0;
        for(Point home: homes) {
            int min = Integer.MAX_VALUE;
            
            for(Point select: selected) {
                min = Math.min(Math.abs(home.r - select.r) + Math.abs(home.c - select.c), min);
            }
            
            sum += min;
        }
        
        return sum;
    }
}

// 치킨집 M개 선택 -> comb
// 모든 집과 치킨거리 구했을 때 최소값
 