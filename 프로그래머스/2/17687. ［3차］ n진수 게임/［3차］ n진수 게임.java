import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static List<String> splitList = new ArrayList<>();
    
    static StringBuilder sb = new StringBuilder();

    public String solution(int n, int t, int m, int p) {
        int size = t*m+1;
        int number = 0;
        int start = p - 1;
        String answer = "";
        
        while(list.size() < size) {
            n진법(n, number);
            number++;
        }
        
        for(int i=0; i<list.size(); i++) {
            String[] stringSplit = list.get(i).split("");
            for(int j=0; j<stringSplit.length; j++) {
                splitList.add(stringSplit[j]);   
            }
        }
        
        for(int i=0; i<t; i++) {
            sb.append(splitList.get(start+(m*i)));
        }
            
        return sb.toString();
    }
    
    public void n진법(int n, int number) {
        if(number==0) {
            list.add("0");
            return;
        }
        while(number > 0) {
            int remain = number % n;
            String convert = "";
            switch(remain) {
                case 10:
                    convert = "A";
                    break;
                case 11:
                    convert = "B";
                    break;
                case 12:
                    convert = "C";
                    break;
                case 13:
                    convert = "D";
                    break;
                case 14:
                    convert = "E";
                    break;
                case 15:
                    convert = "F";
                    break;
                default:
                    convert = String.valueOf(remain);
                    break;
            }
            sb.append(convert);
            number = number / n;
        }
        
        list.add(sb.reverse().toString());
        sb.setLength(0);
    }
}

