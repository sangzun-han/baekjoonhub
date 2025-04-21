import java.util.*;

class Solution {
    static List<Integer> list = new ArrayList<>();
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        comb(n, q, ans, 0, 1);    
        return answer;
    }
    
    public void comb(int n, int[][] q, int[] ans, int depth, int index) {
        if(depth==5) {
            if(calc(q,ans)) answer++;
            return;
        }
        
        for(int i=index; i<=n; i++) {
            list.add(i);
            comb(n, q, ans, depth+1, i+1);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean calc(int[][] q, int[] ans) {
        for(int i=0; i<q.length; i++) {
            int count = 0;
            for(int j=0; j<5; j++) {
                if(list.contains(q[i][j])) {
                    count++;
                }
            }
            
            if(count != ans[i]) return false;
            
        }
        
        return true;
    }
}