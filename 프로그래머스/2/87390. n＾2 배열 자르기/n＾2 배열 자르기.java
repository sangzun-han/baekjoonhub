import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right-left+1);
        int[] answer = new int[size];
                
        for(int i=0; i<size; i++) {
            int r = (int)(left / n);
            int c = (int)(left % n);
            int num = Math.max(r,c);
            answer[i] = num + 1;
            left++;
        }
        
        
        return answer;
    }
}

// 2차원 배열을 직접 만드는건 무조건 시간초과
// 바로 1차원배열안에서 접근하는 방법이 있다. left, right만으로 접근하는 방법이 존재한다.
// 왜? right - left 최대값 10^5
// left ~ right 까지
// arr[left/n][left%n] 으로 접근 가능
// 2차원 배열은 직접 만들면 시간초과인데. 만들지 않고도 가능하다??



