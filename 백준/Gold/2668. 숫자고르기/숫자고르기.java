import java.io.*;
import java.util.*;

public class Main {
    
    static int[] num;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int N = Integer.parseInt(br.readLine());
        
        num = new int[N+1];
        visited = new boolean[N+1];
        
        for(int i=1; i<=N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                dfs(i, i);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        System.out.println(set.size());
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        
    }
    
    public static void dfs(int start, int target) {
        
        if(!visited[num[start]]) {
            visited[num[start]] = true;
            dfs(num[start], target);
            visited[num[start]] = false;
        }
        
        if(num[start]==target) {
            set.add(target);
        }
    }
}

// 정답 : 싸이클 갯수