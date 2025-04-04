import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        
        Arrays.sort(people);
        
        while(left <= right) {
            if(left == right) {
                left++;
                answer++;
                break;
            }
            
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
                answer++;
            } else {
                right--;
                answer++;
            }
            
            
        }
        
        return answer;
    }
}


// 몸무게 낮은애들끼리 묶어서 감 -> 안됨. [70, 80, 70, 10, 10] -> 낮은애들끼리 묶으면 4번 그런데 80,10끼리 묶으면 3번
// 높은애 낮은애끼리 묶어도 안됨 -> 위의경우는 해결하는데 [50,50,70,80] -> 50, 80, 50, 70 4번 그런데 답은 50끼리 묶으면 3번으로 됨 -> 투포인터

// limit 반으로 쪼갬. limit보다 낮은애들 / 2번 + 남은애들  ?? 1번이랑 같은 반례

//

