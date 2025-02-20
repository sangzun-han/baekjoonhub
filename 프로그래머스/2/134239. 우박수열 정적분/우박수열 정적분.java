import java.util.*;

class Solution {
    static List<Integer> list = new ArrayList<>();
    
    public double[] solution(int k, int[][] ranges) {
        collatz(k);
        
        double[] answer = new double[ranges.length];
        double[] sumArea = new double[list.size()-1];
        
        for(int i=0; i<list.size()-1; i++) {
            double area = (list.get(i) + list.get(i+1)) / 2.0;
            sumArea[i] = (i==0) ? area : sumArea[i-1] + area;
        }
        
        for(int i=0; i<ranges.length; i++) {
            int a = ranges[i][0];
            int b = list.size() - 1 + ranges[i][1];
            
            if(a > b) answer[i] = -1;
            else if(a==0 && b==0) {
                answer[i] = 0;
            }
            else if (a==0) {
                answer[i] = sumArea[b-1];
            } else {
                answer[i] = sumArea[b-1] - sumArea[a-1];
            }
        }
        return answer;
    }
    
    public void collatz(int k) {
        list.add(k);
        while(k>1) {
            if(k%2==0) {
                k /= 2;
            }
            else {
                k = k*3+1;
            }
            list.add(k);
        }
    }
}