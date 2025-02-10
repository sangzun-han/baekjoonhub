
import java.util.*;

class Solution {
    static List<List<Integer>> candidate = new ArrayList<>();
    public int solution(String[][] relation) {

        for(int size=1; size<=relation[0].length; size++) {
          comb(relation, 0, size, new ArrayList<>());      
        }
      
        return candidate.size();
    }
    
    public void comb(String[][] relation, int index, int size, List<Integer> currentSet) {
        if(currentSet.size() == size) {
            if(isUnique(currentSet, relation) && isMinimal(currentSet)) {
                candidate.add(new ArrayList<>(currentSet));
            }
            return;
        }
        
        for(int i=index; i<relation[0].length; i++) {
            currentSet.add(i);
            comb(relation, i+1, size, currentSet);
            currentSet.remove(currentSet.size() - 1);
        }
        
    }
    
    public boolean isUnique(List<Integer> currentSet, String[][] relation) {
        Set<String> uniqueRows = new HashSet<>();
        
        for(int i=0; i<relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for(int col: currentSet) {
                sb.append(relation[i][col]).append(" ");    
            }
        
            if(uniqueRows.contains(sb.toString())) {
                return false;
            }
            
            uniqueRows.add(sb.toString());
        }
        
        return true;
    }
    
    public boolean isMinimal(List<Integer> currentSet) {
        for(List<Integer> key: candidate) {
            if(currentSet.containsAll(key)) {
                return false;
            }
        }
        
        return true;
    }
    
}