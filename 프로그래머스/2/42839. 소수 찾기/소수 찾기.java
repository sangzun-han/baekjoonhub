import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        String[] splitNumbers = numbers.split("");
        visited = new boolean[splitNumbers.length];
        perm("", splitNumbers);
        for(int n: set) {
            if(isPrime(n)) answer++;
        }
        return answer;
    }
    
    public void perm(String cur, String[] numbers) {
        if(numbers.length < cur.length()) return;
        if(cur.length()!=0) {
            set.add(Integer.parseInt(cur));
        }
        
        for(int i=0; i<numbers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                perm(cur+numbers[i], numbers);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int number) {
        boolean flag = true;
        if(number==0 || number==1) return false;
        for(int i=2; i<=(int)Math.sqrt(number); i++) {
            if(number%i==0) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
    
}