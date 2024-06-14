import java.util.*;

class Solution {
    static Stack<Integer> stack = new Stack<>();
    static int[][] map;
    static int SIZE;
    static int answer = 0;
    public int solution(int[][] board, int[] moves) {
        map = board;
        SIZE = board.length;
        for(int i=0; i<moves.length; i++) {
            bombMap(moves[i]);
        }

        return answer;
    }
 
    private static void bombMap(int col) {
        for(int i=0; i<SIZE; i++) {
            if(map[i][col-1] != 0) {
                int doll = map[i][col-1];
                map[i][col-1] = 0;
                if(!stack.isEmpty() && stack.peek() == doll) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(doll);     
                }
               break;
            }
        }
    }
}