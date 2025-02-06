import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public String solution(int n, int t, int m, int p) {
        
        String answer = "";
        int size = t*m+1;
        int number = 0;
        while(list.size() < size) {
            nbase(n, number);
            number++;
        }
        
        for(int i=0; i<t; i++) {
            sb.append(list.get(p-1 + (i *m)));
        }
        return sb.toString();
    }
    
    public void nbase(int n, int number) {
        if(number == 0) {
            list.add("0");
            return;
        }
        
        while(number > 0) {
            int remain = number % n;
            String convert = "";
            switch(remain) {
                case 10: convert = "A"; break;
                case 11: convert = "B"; break;
                case 12: convert = "C"; break;
                case 13: convert = "D"; break;
                case 14: convert = "E"; break;
                case 15: convert = "F"; break;
                default: convert = String.valueOf(remain);
            }
            sb.append(convert);
            number = number / n;
        }
        sb.reverse();
        
        for(int i=0; i<sb.length(); i++) {
            list.add(String.valueOf(sb.charAt(i)));
        }
        
        sb.setLength(0);
    }
}