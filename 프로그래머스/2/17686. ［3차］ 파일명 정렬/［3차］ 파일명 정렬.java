import java.util.*;

class Word implements Comparable<Word>{
    String head;
    String number;
    String tail;
    
    Word(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
    
    @Override
    public int compareTo(Word w) {
        int headCompare = this.head.compareToIgnoreCase(w.head);
        if (headCompare != 0) return headCompare;

        return Integer.compare(Integer.parseInt(this.number), Integer.parseInt(w.number));
    }
}

class Solution {
    static List<Word> list = new ArrayList<>();
    
    public String[] solution(String[] files) {
        
        for(int i=0; i<files.length; i++) {
            splitWord(files[i]);
        }
        String[] answer = new String[list.size()];
        Collections.sort(list);
        
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).head + list.get(i).number + list.get(i).tail;
        }
        return answer;
    }
    
    public void splitWord(String file) {
        String HEAD = "";
        String NUMBER = "";
        String TAIL = "";
        
        int size = file.length();
        int index = 0;
     
        while(index < size && !Character.isDigit(file.charAt(index))) {
            HEAD += String.valueOf(file.charAt(index));
            index++;
        }
        
        while(index < size && Character.isDigit(file.charAt(index))) {
            NUMBER += String.valueOf(file.charAt(index));
            index++;
        }
        
        while(index < size) {
            TAIL += String.valueOf(file.charAt(index));
            index++;
        }
        
        list.add(new Word(HEAD, NUMBER, TAIL));
    }
}