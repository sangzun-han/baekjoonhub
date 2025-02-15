import java.util.*;

class Solution {
    static int size = 8;
    static String[] kakaoFriends = {"A","C","F","J","M","N","R","T"};
    static boolean[] selected = new boolean[size];
    static List<String> kakaoFriendsList = new ArrayList<>();
    static int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        perm(0, data);
        return answer;
    }
    
    public void perm(int depth, String[] data) {
        if(kakaoFriendsList.size()==size) {
            calc(data);
            return;
        }
        
        for(int i=0; i<size; i++) {
            if(!selected[i]) {
                selected[i] = true;    
                String kakaoFriend = kakaoFriends[i];
                kakaoFriendsList.add(kakaoFriend);
                perm(i+1, data);            
                selected[i] = false;
                kakaoFriendsList.remove(kakaoFriendsList.size() -1);
            }
        }
    }
    
    public void calc(String[] data) {
        boolean isCondition = true;
        for(int i=0; i<data.length; i++) {
            String condition = data[i];
            
            String first = String.valueOf(condition.charAt(0));
            String second = String.valueOf(condition.charAt(2));
            String op = String.valueOf(condition.charAt(3));
            int distance = Integer.parseInt(String.valueOf(condition.charAt(4)));
            
            int firstIndex = kakaoFriendsList.indexOf(first);
            int secondIndex = kakaoFriendsList.indexOf(second);
            int friendDistance = Math.abs(firstIndex - secondIndex);
            
            if(op.equals("=")) {
                if(friendDistance-1 != distance) {
                    isCondition = false;
                    break;
                }
            } else if(op.equals(">")) {
                if(friendDistance-1 <= distance) {
                    isCondition = false;
                    break;
                }
            } else if(op.equals("<")) {
                if(friendDistance-1 >= distance) {
                    isCondition = false;
                    break;
                }
            }
        }
        
        if(isCondition) answer++;
    }
}