import java.util.*;

class Solution {
    static int answer;

    public int solution(int[][] points, int[][] routes) {
        answer = 0;
        int[][] robotPositions = new int[routes.length][2];
        int[] routeIndex = new int[routes.length]; // 로봇이 현재 향하는 포인트 인덱스
        boolean[] isFinished = new boolean[routes.length];
        boolean isFinish = false;
        
        // 시작 위치를 설정
        for (int i = 0; i < routes.length; i++) {
            int start = routes[i][0] - 1;
            int[] startPoint = points[start];

            robotPositions[i][0] = startPoint[0];
            robotPositions[i][1] = startPoint[1];
        }
        
        while (!isFinish) {
            Map<String, Integer> positionCount = new HashMap<>();

            for (int i = 0; i < routes.length; i++) {
                if (isFinished[i]) continue;

                // 현재 목표 지점 찾기
                int end = routes[i][routeIndex[i]] - 1;
                int[] endPoint = points[end];

                // r 먼저 이동
                if (robotPositions[i][0] != endPoint[0]) {
                    robotPositions[i][0] += (endPoint[0] - robotPositions[i][0] < 0) ? -1 : 1;
                } 
                // r이 맞춰졌으면 c 이동
                else if (robotPositions[i][1] != endPoint[1]) {
                    robotPositions[i][1] += (endPoint[1] - robotPositions[i][1] < 0) ? -1 : 1;
                }

                // 이동 후 도착했을 때만 routeIndex 증가 ✅ (한 번만 증가)
                if (robotPositions[i][0] == endPoint[0] && robotPositions[i][1] == endPoint[1]) {
                    routeIndex[i]++;
                    if (routeIndex[i] >= routes[i].length) {
                        isFinished[i] = true;
                    }
                }

                String key = robotPositions[i][0] + "," + robotPositions[i][1];
                positionCount.put(key, positionCount.getOrDefault(key, 0) + 1);
                
            }
            
            for (int count : positionCount.values()) {
                if (count > 1) answer++;
            }
            
            // 모든 로봇이 도착했는지 체크
            isFinish = true;
            for (boolean finished : isFinished) {
                if (!finished) {
                    isFinish = false;
                    break;
                }
            }
        }
        return answer;
    }
}
