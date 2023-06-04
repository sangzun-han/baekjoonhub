import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;
        char[] sArray = s.toCharArray();
        
        for(int i=0; i<sArray.length; i++) {
            if(sArray[i]=='y' || sArray[i]=='Y') yCount++;
            else if(sArray[i]=='p' || sArray[i]=='P') pCount++;
        }
        if(pCount==yCount) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}