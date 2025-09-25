import java.util.*;

class Node {
    String word;
    int level;
    
    Node(String word, int level) {
        this.word = word;
        this.level = level;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(node.word.equals(target)) return node.level;
            
            for(int i=0; i<words.length; i++) {
                String word = words[i];
                
                if(visited[i]) continue;
                
                int count = 0;
                for(int j=0; j<word.length(); j++) {
                    if(word.charAt(j) == node.word.charAt(j)) {
                        count++;
                    }
                }
                
                if(count==word.length()-1) {
                    queue.offer(new Node(word, node.level+1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}