import java.util.*;

class Solution {
    static List<Integer> number = new ArrayList<>();
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        comb(0,1,n,q,ans);
        return answer;
    }
    
    public void comb(int count, int index, int n, int[][] q, int[] ans) {
        if(count==5) {
            if(checkMath(q,ans)) answer++;
            return;
        }
        
        for(int i=index; i<=n; i++) {
            number.add(i);
            comb(count + 1, i+1, n, q, ans);
            number.remove(number.size() -1);
        }
    }
    
    public boolean checkMath(int[][] q, int[] ans) {
        for(int i=0; i<q.length; i++) {
            int count = 0;
            for(int j=0; j<5; j++) {
                if(number.contains(q[i][j])) {
                    count++;
                }
            }
            if(count!=ans[i]) return false;
        }
        
        return true;
    }
}