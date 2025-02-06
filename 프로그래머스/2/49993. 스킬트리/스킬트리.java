import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        
        for(int i=0; i<skill_trees.length; i++) {
            String skill_tree = skill_trees[i];
            
            for(char c: skill_tree.toCharArray()) {
                if(!skill.contains(String.valueOf(c))) {
                    skill_tree = skill_tree.replace(String.valueOf(c),"");
                }
            }
            skill_trees[i] = skill_tree;
        }
        
        for(int i=0; i<skill_trees.length; i++) {
            if(skill.startsWith(skill_trees[i])) answer++;
        }
        
       
        return answer;
    }
}

