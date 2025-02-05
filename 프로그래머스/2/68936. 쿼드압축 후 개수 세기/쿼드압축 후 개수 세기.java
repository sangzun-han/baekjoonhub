import java.util.*;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int zeroCount = 0;
    static int oneCount = 0;
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int N = arr.length;
        recursive(new Point(0,0), new Point(N,N), arr);
        answer[0] = zeroCount;
        answer[1] = oneCount;
        return answer;
    }
    
    public void recursive(Point p1, Point p2, int[][] arr) {
        int startX = p1.x;
        int startY = p1.y;
        int endX = p2.x;
        int endY = p2.y;
        int size =  Math.abs(endX - startX);
        int one = 0;
        int zero = 0;
        for(int i=startX; i<endX; i++) {
            for(int j=startY; j<endY; j++) {
                if(arr[i][j]==1) one++;
                else if(arr[i][j]==0) zero++;
            }
        }
        int newSize = size / 2;
        
        if(zero==size*size) zeroCount++;
        else if(one==size*size) oneCount++;
        else {
            recursive(new Point(startX, startY), new Point(startX + newSize, startY + newSize), arr); // 좌상
            recursive(new Point(startX, startY + newSize), new Point(startX + newSize, startY + size), arr); // 우상
            recursive(new Point(startX + newSize, startY), new Point(startX + size, startY + newSize), arr); // 좌하
            recursive(new Point(startX + newSize, startY + newSize), new Point(startX + size, startY + size), arr); // 우하
        }
    }
}
// 1. 재귀적 접근을 하는게 좋아보임
// 2. 재귀에서는 표를 n/2, n/2로 나눔
// 3. n/2, n/2로 나누었을때 반복을 모두 도는데 이때 0 또는 1의 갯수가 n/2와 동일하다면 0,1 더해놓고 그게 아니라면 다시 재귀