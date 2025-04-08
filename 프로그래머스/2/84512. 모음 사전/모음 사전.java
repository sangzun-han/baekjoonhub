class Solution {
    static String[] 모음 = {"A", "E", "I", "O", "U"};
    static int answer;
    static int count;
    
    public int solution(String word) {
        answer = 0;
        count = 0;
        dfs("", word);    
        return answer;
    }
    
    public void dfs(String current, String target) {
        if(current.equals(target)) {
            answer = count;
            return;
        }
        
        if(current.length() >= 5) return;
        
        for(int i=0; i<5; i++) {
            count++;
            dfs(current + 모음[i], target);
        }
    }
}