class Solution {
    public int solution(String name) {
        int answer = 0;
        int size = name.length();
        char[] start = new char[size];
        
        for(int i=0; i<size; i++) {
            start[i] = 'A';
        }
        int move = size - 1;
        
        for(int i=0; i<size; i++) {
            if(start[i] != name.charAt(i)) {
                int upDown = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
                answer += upDown;
                start[i] = name.charAt(i);
            }
            
            // 커서 이동

            int next = i + 1;
            
            while(next < size && name.charAt(next)=='A') {
                next++;
            }
            
            move = Math.min(move, i*2 + (size-next));
            move = Math.min(move, (size-next)*2 + i);
        }
        
        return answer+move;
    }
}