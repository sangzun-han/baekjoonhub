class Solution {
    public String solution(String s) {
        int size = s.length();
        String answer = "";
        if(size%2==0) {
            answer += s.charAt(size/2-1);
            answer += s.charAt(size/2);
        } else {
            answer += s.charAt(size/2);
        }
        return answer;
    }
}