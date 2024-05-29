import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[n];
        
        int[][] map = new int[n][n];
        int[][] map2 = new int[n][n];
        String[][] copyMap = new String[n][n];
        
        for(int i=0; i<n ;i++) {
            int[] side = makeBinary(n, arr1[i]);
            map[i] = side;
            int[] side2 = makeBinary(n, arr2[i]);
            map2[i] = side2;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j]==1 || map2[i][j]==1) {
                    copyMap[i][j] = "#";
                } else {
                    copyMap[i][j] = " ";
                }
            }        
        }
        

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(copyMap[i][j]);
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        
        return answer;
    }
    
    public int[] makeBinary(int n, int num) {
        int[] side = new int[n];
        int count = 0;
        while(num!=0) {
            int remain = num % 2;
            num =  num / 2;
            side[n-count-1] = remain;
            count++;
        }
        
        
        return side;
        
    }
}
