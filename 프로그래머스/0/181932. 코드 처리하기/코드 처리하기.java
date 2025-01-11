class Solution {
    public String solution(String code) {
        
        StringBuilder sb = new StringBuilder();
        int mode = 0;
        String[] codes = code.split("");
        
        for(int i=0; i<codes.length; i++) {
            if(mode == 0) {
                if(codes[i].equals("1")) {
                    mode = 1;
                } else {
                    if(i%2==0) {
                        sb.append(codes[i]);
                    }
                }
            }
            
            else if(mode == 1) {
                if(codes[i].equals("1")) {
                    mode = 0;
                } else {
                    if(i%2==1) {
                        sb.append(codes[i]);
                    }
                }
            }
        }
      
        return sb.toString().length() == 0 ? "EMPTY" : sb.toString();
    }
}