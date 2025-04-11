import java.util.*;

class Document implements Comparable<Document>{
    String head;
    String number;
    String tail;
    
    Document(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
    
    @Override
    public int compareTo(Document document) {
        if(this.head.equalsIgnoreCase(document.head)) {
            return Integer.parseInt(this.number) - Integer.parseInt(document.number);
        }    
        return this.head.compareToIgnoreCase(document.head);
        
    }
}

class Solution {
    static List<Document> documentList = new ArrayList<>();
    
    public String[] solution(String[] files) {
        StringBuilder sb = new StringBuilder();

        
        for(int i=0; i<files.length; i++) {
            String file = files[i];
            divideFileName(file);
        }
        
        Collections.sort(documentList);
        String[] answer = new String[documentList.size()];
    
        for(int i=0; i<documentList.size(); i++) {
            sb.append(documentList.get(i).head)
                .append(documentList.get(i).number)
                .append(documentList.get(i).tail);
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        
        return answer;
    }
    
    public void divideFileName(String file) {
        int headIndex = 0;
        int numberIndex = 0;
        
        for(int j=0; j<file.length(); j++) {
            if(Character.isDigit(file.charAt(j))) {
                headIndex = j;
                break;
            }
        }
        
        String HEAD = file.substring(0,headIndex);
        
        for(int j=headIndex; j<file.length(); j++) {
            if(!Character.isDigit(file.charAt(j))) {
                numberIndex = j;
                break;
            }
        }
        
        if (numberIndex == 0) {
            numberIndex = file.length();
        }
        
        String NUMBER = file.substring(headIndex, numberIndex);
        String TAIL = file.substring(numberIndex);
        
        documentList.add(new Document(HEAD, NUMBER, TAIL));
    }
}


