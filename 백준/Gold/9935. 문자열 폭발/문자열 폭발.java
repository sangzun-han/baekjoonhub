import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        String boom = br.readLine();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            boolean isBoom = true;
            if(sb.length() >= boom.length()) {
                for(int j=0; j<boom.length(); j++) {
                    if(sb.charAt(sb.length() - boom.length() + j) != boom.charAt(j)) {
                        isBoom = false;
                        break;
                    }
                }
                
                if(isBoom) {
                    sb.setLength(sb.length() - boom.length());
                }
            }
            
        }
        
        if(sb.length()==0) System.out.println("FRULA");
        else System.out.println(sb.toString());
    }
}
