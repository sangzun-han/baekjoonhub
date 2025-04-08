import java.util.*;

class Solution {
    public int solution(String dirs) {
        StringBuilder sb = new StringBuilder();
        Set<String> street = new HashSet<>();
        int n = 10;
        int m = 10;
        int currentR = 5;
        int currentC = 5;

        for(int i=0; i<dirs.length(); i++) {
            char c = dirs.charAt(i);
  
            if(c=='U') {
                if(currentR+1>=0 && currentR+1<=n) {
                    String s1 = sb.append("(").append(currentR).append(",").append(currentC).append(")").toString();
                    currentR++;
                    sb.setLength(0);
                    String s2 = sb.append("(").append(currentR).append(",").append(currentC).append(")").toString();
                    street.add(s1+s2);
                    street.add(s2+s1);
                    sb.setLength(0);
                }
            } else if(c=='D') {
                if(currentR-1>=0 && currentR-1<=n) {
                    String s1 = sb.append("(").append(currentR).append(",").append(currentC).append(")").toString();
                    currentR--;
                    sb.setLength(0);
                    String s2 = sb.append("(").append(currentR).append(",").append(currentC).append(")").toString();
                    street.add(s1+s2);
                    street.add(s2+s1);
                    sb.setLength(0);
                }
            } else if(c=='R') {
                if(currentC+1>=0 && currentC+1<=m) {
                    String s1 = sb.append("(").append(currentR).append(",").append(currentC).append(")").toString();
                    currentC++;
                    sb.setLength(0);
                    String s2= sb.append("(").append(currentR).append(",").append(currentC).append(")").toString();
                    street.add(s1+s2);
                    street.add(s2+s1);
                    sb.setLength(0);
                }
            } else if(c=='L') {
                if(currentC-1>=0 && currentC-1<=m) {
                    String s1 = sb.append("(").append(currentR).append(",").append(currentC).append(")").toString();
                    currentC--;
                    sb.setLength(0);
                    String s2 = sb.append("(").append(currentR).append(",").append(currentC).append(")").toString();
                    street.add(s1+s2);
                    street.add(s2+s1);
                    sb.setLength(0);
                }
            }
        }
        
       
        return street.size() / 2;
    }
}