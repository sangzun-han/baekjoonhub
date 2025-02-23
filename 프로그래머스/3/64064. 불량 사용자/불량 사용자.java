import java.util.*;

class Solution {
    static int size;
    static boolean[] selected;
    static Set<Set<String>> setValid = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        size = banned_id.length;
        selected = new boolean[user_id.length];
        perm(user_id, banned_id, new ArrayList<>());
        return setValid.size();
    }
    
    
    public void perm(String[] user_id, String[] banned_id, List<String> selectedList) {
        if(selectedList.size() == size) {
            if(isValid(selectedList, banned_id)) {
                setValid.add(new HashSet<>(selectedList));
            }
            return;
        }
        
        for(int i=0; i<user_id.length; i++) {
            if(!selected[i]) {
                selected[i] = true;
                selectedList.add(user_id[i]);
                perm(user_id, banned_id, selectedList);
                selected[i] = false;
                selectedList.remove(selectedList.size() - 1);
            }
        }
    }
    
    public boolean isValid(List<String> selectedList, String[] banned_id) {        
        for(int i=0; i<size; i++) {
            if(!isMatching(selectedList.get(i), banned_id[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isMatching(String user_id, String ban_id) {
        if(user_id.length() != ban_id.length()) return false;
        
        for(int i=0; i<user_id.length(); i++) {
           if(ban_id.charAt(i) != '*' && user_id.charAt(i) != ban_id.charAt(i)) {
               return false;
           }
        }
        
        return true;
    }
}