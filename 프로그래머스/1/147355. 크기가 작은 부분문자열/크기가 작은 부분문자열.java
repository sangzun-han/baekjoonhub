class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLen = t.length();
        int pLen = p.length();
        
        for(int i=0; i<=tLen-pLen; i++) {
           String number = t.substring(i, i+pLen);
            if(p.compareTo(number)>=0) answer++;
        }
        
        return answer;
    }
}