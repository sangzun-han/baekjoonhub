class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String s = String.valueOf(x);
        String[] split = s.split("");
        int div = 0;
        for(int i=0; i<split.length; i++) {
            div += Integer.parseInt(split[i]);
        }
      
        if(x%div==0) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}