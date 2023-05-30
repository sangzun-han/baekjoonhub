class Solution {
    public int[] solution(String[] park, String[] routes) {
         int[] answer = new int[2];
        int row = park.length;
        int column = park[0].length();
        int startX = 0;
        int startY = 0;
        // 시작위치 찾기
        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                if(park[i].charAt(j)=='S') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }

        int x = startX;
        int y = startY;
        for(int i=0; i<routes.length; i++) {
            String op = routes[i].split(" ")[0];
            int n = Integer.parseInt(routes[i].split(" ")[1]);
            int nx = x;
            int ny = y;
            boolean flag = true;
            for(int j=0; j<n; j++) {
                if (op.equals("N")) nx--;
                if (op.equals("S")) nx++;
                if (op.equals("W")) ny--;
                if (op.equals("E")) ny++;

                if (nx < 0 || ny < 0 || nx >= row || ny >= column || park[nx].charAt(ny)=='X') {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                x = nx;
                y = ny;
            }
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}