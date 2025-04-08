import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        int[] leftKind = new int[size];
        int[] rightKind = new int[size];
        
        for(int i=0; i<size; i++) {
            left.add(topping[i]);
            leftKind[i] = left.size();    
        }
        
        for(int i=size-1; i>=0; i--) {
            right.add(topping[i]);
            rightKind[i] = right.size();    
        }
        
        for(int i=0; i<size-1; i++) {
            if(leftKind[i]==rightKind[i+1]) answer++;
        }
        return answer;
    }
}

// 이중반복 x -> 시간초과
// 그리디? 모든 토핑 종류 set에저장, -> 토핑의 수를 알 수 있음 그래도안됨
// 자료구조로 set이용?
// 공평하게 자르는 방법의 수니까 결국 완탐 돌긴해야함
// 어떻게 자르냐?
// 1개 2개 3개 4개 n개
// map
// 누적합? 0부터 I까지갯수 i부터 n까지 개수 dp?
// left[i] : 0~i까지의 토핑 갯수
// right[i] : i~n-1까지 토핑의 개수
