import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int aCount = 0;
        int answer = 1001;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='a') aCount++;
        }
    
        for(int i=0; i<s.length(); i++) {
            int bCount = 0;
            for(int j=i; j<i+aCount; j++) {
                if(s.charAt(j % s.length())=='b') bCount++;
            }
            
            answer = Math.min(answer, bCount);
        }    
        
        System.out.println(answer);
    }
    
}



// a와 b를 직접 교환할 필요 X
// a가 연속 = a의 개수가 모두 일렬로 있으면 됌
// a개수 다 세고, 처음부터 끝까지 a개수만큼 반복돌면서 b의 개수 카운트
// a가 7이라면 7개의 배열안에 b의 개수만큼 교환을하면 결국 a가 모두 연속 이떄 b의 값이 최소일때 답
 