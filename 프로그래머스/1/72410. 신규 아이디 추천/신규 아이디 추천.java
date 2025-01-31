import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        // 1. 소문자로 변환
        String replaceId = new_id.toLowerCase();
        System.out.println("1단계 " + replaceId);
        // 2. 소문자, 숫자, -,_,, 제외 제거
        for(int i=0; i<replaceId.length(); i++) {
            char c = replaceId.charAt(i);
            if(c == '-' || c == '_' || c == '.' || Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        replaceId = sb.toString();
        System.out.println("2단계 " + replaceId);
        sb = new StringBuilder();
        
        boolean dot = false;
        // 3.연속된 마침표(.) 하나의 마침표로
        for(int i=0; i<replaceId.length(); i++) {
            char cur = replaceId.charAt(i);
            if(cur == '.') {
                if(!dot) {
                    dot = true;
                    sb.append(cur);
                }
            } else {
                dot = false;
                sb.append(cur);
            }   
        }
        replaceId = sb.toString();
 
        System.out.println("3단계 " + replaceId);
        // 4. 마침표(.) 처음이나 끝에 위치시 제거
        if(replaceId.startsWith(".")) {
            replaceId = replaceId.substring(1,replaceId.length());
        }
        
        if(replaceId.endsWith(".")) {
            replaceId = replaceId.substring(0, replaceId.length()-1);
        }
        
        System.out.println("4단계 " + replaceId);
        
        // 5.빈문자열이라면 a대입
        if(replaceId.isEmpty()) {
            replaceId = "a";
        }
        System.out.println("5단계 " + replaceId);
        
        // 6.16이상 0~15까지만, 마침표 끝에위치시 제거
        if(replaceId.length() >= 16) {
            replaceId = replaceId.substring(0,15);
        }
        
         if(replaceId.endsWith(".")) {
            replaceId = replaceId.substring(0, replaceId.length()-1);
        }
        System.out.println("6단계 " + replaceId);
        
        if(replaceId.length() <= 2) {
            char lastString = replaceId.charAt(replaceId.length()-1);
            while(replaceId.length() != 3) {
                replaceId += lastString;
            }
        }
        System.out.println("7단계 " + replaceId);
        
       
        
        return replaceId;
    }
}