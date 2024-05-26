import java.util.*;

class Solution {
    public class Node {
    String word;
    int level;
    
    Node(String word, int level) {
        this.word = word;
        this.level = level;
    }
}
    
    public int solution(String begin, String target, String[] words) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new Node(begin, 0));
        
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            String curWord = cur.word;
            int curLevel = cur.level;
            
            if(curWord.equals(target)) {
                return curLevel;
            }
            
            for(int i=0; i<words.length; i++) {
                String word = words[i];
                
                if(visited[i]) continue;
                
                int count = 0;
                for(int j=0; j<word.length(); j++) {
                    if(curWord.charAt(j) == word.charAt(j)) {
                        count++;
                    }
                }
                
                if(count == word.length()-1) {
                    visited[i] = true;
                    queue.offer(new Node(word, curLevel+1));
                }
            }
        }
        
        return 0;
        
 
    }
}