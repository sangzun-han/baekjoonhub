import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder answerBuilder = new StringBuilder();
        
        String n;
        
        while((n = br.readLine()) != null) {
            int N = Integer.parseInt(n);
            int number = 1;
            for(int i=0; i<N; i++) {
                number = number * 3;
            }
            for(int i=0; i<number; i++) {
                sb.append("-");
            }
            
            dfs(sb.toString());
            answerBuilder.append(answer.toString()).append("\n");
            sb.setLength(0);
            answer.setLength(0);
        }
        System.out.print(answerBuilder.toString());
    }
    
    public static void dfs(String line) {
        if(line.length()==1) {
            answer.append(line);
            return;
        }
        
        //가운데 문자열 공백으로 만들고 잘린 3부분 모두 다시 dfs
        int part = line.length() / 3;
        dfs(line.substring(0,part));
        StringBuilder blank = new StringBuilder();
        for(int i=part; i<part*2; i++) {
            blank.append(" ");
        }
        answer.append(blank);
        dfs(line.substring(part*2, part*3));    
    }
}
