import java.util.*;

class Solution {
    static class Word implements Comparable<Word>{
        String original;
        char c;
        int num;
        
        public Word(String original, char c, int num) {
            this.original = original;
            this.c = c;
            this.num = num;
        }
        
        @Override
        public int compareTo(Word w) {
            if(w.c == this.c) {
                return this.original.compareTo(w.original);
            }
            return this.c - w.c;
        }
    }
    public String[] solution(String[] strings, int n) {
       
        ArrayList<Word> list = new ArrayList<>();
        
        for(int i=0; i<strings.length; i++) {
            list.add(new Word(strings[i], strings[i].charAt(n), i+1));
        }
        
        Collections.sort(list);
        String[] answer = new String[list.size()];
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).original;
        }
        
        return answer;
    }
}