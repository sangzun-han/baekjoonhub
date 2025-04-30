import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Map<Character, Integer> map = new HashMap<>();
    static int wordLength;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            if(i==0) {
                wordLength = s.length();
                for(int j=0; j<s.length(); j++) {
                    char c = s.charAt(j);
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }    
            } else {
                if(isSimilar(s)) answer++;
            }
        }
        
        System.out.println(answer);
    }
    
    public static boolean isSimilar(String s) {
        // 단어 길이 1이상 차이나면 비슷한 단어 못함
        if(Math.abs(wordLength - s.length()) >= 2) return false;
        
        Map<Character, Integer> similar = new HashMap<>(map);
        
        for(char c: s.toCharArray()) {
            similar.put(c, similar.getOrDefault(c, 0) - 1);
        }
        
        int plus = 0; // s에만 존재하거나 더 많은 문자 수
        int minus = 0; // 기준 단어에만 존재하거나 더 많은 문자 수
        
        // value가 양수 ->  삭제됨
        // value가 음수 ->  삽입됨
        
        for(int value: similar.values()) {
            if(value > 0) minus += value;
            else plus -= value;
        }
        
        if(plus==0 && minus==0) return true;
        if(plus==1 && minus==0) return true;
        if(plus==0 && minus==1) return true;
        if(plus==1 && minus==1) return true;
        
        return false;
        
        
        
  
                
    }
}
