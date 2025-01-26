class Solution {
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        int startX = 0;
        int startY = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(park[i].charAt(j)=='S') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
 
        int x = startX;
        int y = startY;
        for(int i=0; i<routes.length; i++) {
            String[] s = routes[i].split(" ");
            String op = s[0];
            int c = Integer.parseInt(s[1]);
            int nx = x;
            int ny = y;
            boolean flag = true;
            for(int j=0; j<c; j++) {
                if(op.equals("N")) nx--;
                else if (op.equals("S")) nx++;
                else if (op.equals("W")) ny--;
                else if (op.equals("E")) ny++;
                
                if(nx<0 || nx>=n || ny<0 || ny>=m || park[nx].charAt(ny)=='X') {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                x = nx;
                y = ny;
            }
            
            
        }
        
        int[] answer = new int[2];
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}
