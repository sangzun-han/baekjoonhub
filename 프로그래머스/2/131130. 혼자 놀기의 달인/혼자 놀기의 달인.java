import java.util.*;

class Card {
    int number;
    boolean isUse;
    
    Card(int number, boolean isUse) {
        this.number = number;
        this.isUse = isUse;
    }
}

class Solution {
    static Map<Integer, Card> map = new HashMap<>();
    static int count;
    
    public int solution(int[] cards) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<cards.length; i++) {
            map.put(i+1, new Card(cards[i], false));
        }
        
        for(int i=0; i<cards.length; i++) {
            if(!map.get(i+1).isUse) {
                count = 0;
                dfs(i+1);
                if(count > 0) list.add(count);
            }
        }
   
        if(list.size() >= 2) {
            Collections.sort(list);
            int n = list.get(list.size()-1);
            int m = list.get(list.size()-2);
            answer = n*m;  
        } else if(list.size()==1) {
            answer = 0;
        }
        
        return answer;
    }
    
    public void dfs(int index) {
        Card card = map.get(index);
        if(card.isUse) return;
        
        if(!card.isUse) {
            count++;
            card.isUse = true;
            dfs(card.number);
        }
    }
}