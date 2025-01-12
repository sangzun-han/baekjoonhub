class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int diff = 0;
        char start = s.charAt(0);
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == start) {
                same++;
            } else {
                diff++;
            }
            
            if(same == diff) {
                answer++;
                
                if(i+1 < s.length()) {
                    start = s.charAt(i+1);
                }
                same = 0;
                diff = 0;
            }
        }
        if(same !=0 || diff !=0) {
            answer++;
        }
        return answer;
    }
}