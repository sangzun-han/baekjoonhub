class Solution {
    public int solution(String skill, String[] skill_trees) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++) {
            String skill_tree = skill_trees[i];
            
            for(int j=0; j<skill_tree.length(); j++) {
                String s = String.valueOf(skill_tree.charAt(j));
                if(skill.contains(s)) {
                    sb.append(s);
                }
            }
            
            if(skill.startsWith(sb.toString())) answer++;
            sb.setLength(0);
        }
        return answer;
    }
}


// skill_trees에서 skill에 있는 문자로만 표현 -> skill에 없다면 빈걸로 만들든 sb쓰든
// 이후에 startsWith 쓰면될듯?