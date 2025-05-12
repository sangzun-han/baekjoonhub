import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean found = false;
    static boolean[] selected;
    static List<Integer> selectedList = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        selected = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        perm(0, arr);
    }
    
    public static void perm(int count, int[] arr) {
        if(found) return;
        if(count==N) {
            if(go(arr)) {
                for(int number: selectedList) {
                    System.out.print(number+" ");
                }
            }
            
            return;
        }
        
        for(int i=0; i<N; i++) {
            if(!selected[i]) {
                selectedList.add(i+1);
                selected[i] = true;
                perm(count+1, arr);
                selectedList.remove(selectedList.size() - 1);
                selected[i] = false;
            }
        }
    }
    
    public static boolean go(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            // i+1번째 앞에는 front명이 존재한다.
            int front = arr[i];
            int count = 0;
          
            int personIndex = selectedList.indexOf(i + 1);

            // 그 사람 앞에 큰 사람 몇 명인지 세기
            for (int j = 0; j < personIndex; j++) {
                if (selectedList.get(j) > i + 1) {
                    count++;
                }
            }
            
           
            if (count != front) return false;
        }
        
        found = true;
        return found;
    }
    
}

