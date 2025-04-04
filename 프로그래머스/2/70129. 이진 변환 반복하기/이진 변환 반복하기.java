class Solution {
    static int removeZeroCount = 0;
    static int loopCount = 0;
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(true) {
            // 0을 모두 제거한다.
            s = removeZero(s);
            // s의 길이를 c 한다면, 
            int c = s.length();
            //길이를 다시 이진법으로 바꾼다
            s = converBinaryScale(c);
            loopCount++;
            if(s.equals("1")) break;
        }
        answer[0] = loopCount;
        answer[1] = removeZeroCount;
        
        return answer;
    }
    
    
    public String removeZero(String s) {
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='0') removeZeroCount++;
        }
        
        return s.replace("0","").trim();
    }
    
    public String converBinaryScale(int c) {
        StringBuilder sb = new StringBuilder();
        
        while(c != 0) {
            sb.append(c % 2);
            c /= 2;   
        }
        return sb.reverse().toString();
    }
    
}



