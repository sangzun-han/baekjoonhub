class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int index = 0;
        
        for(int[] ball: balls) {
            int minDistance = Integer.MAX_VALUE;
            
            int ballX = ball[0];
            int ballY = ball[1];
            
            int[][] mirrors = {{-ballX, ballY}, {2*m-ballX, ballY}, {ballX, 2*n-ballY}, {ballX, -ballY}};
        
            
            for(int[] mirror: mirrors) {
                if (startY == ballY) {
                    if (ballX > Math.min(startX, mirror[0]) && ballX < Math.max(startX, mirror[0])) {
                        continue;
                    }
                }

                if (startX == ballX) {
                    if (ballY > Math.min(startY, mirror[1]) && ballY < Math.max(startY, mirror[1])) {
                        continue;
                    }
                }
                int distance = (startX - mirror[0]) * (startX - mirror[0]) + (startY - mirror[1]) * (startY - mirror[1]);
                minDistance = Math.min(minDistance, distance);
            }
            
            answer[index++] = minDistance;
        }
        
        return answer;
    }
}