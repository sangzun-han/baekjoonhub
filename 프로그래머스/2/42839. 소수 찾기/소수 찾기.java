import java.util.*;

class Solution {
    static int n = 10000000;
    static boolean[] selected;
    static boolean[] isPrime = new boolean[n+1];
    static int answer;
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(String numbers) {
        answer = 0;
        String[] numberSplit = numbers.split("");
        int len = numberSplit.length;
        prime();
        
        for(int size=1; size<=len; size++) {
            selected = new boolean[len];
            perm(numberSplit, size, "");    
        }
        
        return answer;
    }
    
    public void perm(String[] number, int size, String cur) {
        if(cur.length() == size) {
            int curNum = Integer.parseInt(cur);
            int isDuplicate = map.getOrDefault(curNum, 0);
            if(isDuplicate > 0) return;
            map.put(curNum, 1);
            if(isPrime[curNum]) answer++;
            
            return;
        }
        
        for(int i=0; i<number.length; i++) {
            if(!selected[i]) {
                selected[i] = true;
                perm(number, size, cur + number[i]);
                selected[i] = false;
            }
        }
    }
    
    public void prime() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int i=2; i*i<=n; i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    
    
}

