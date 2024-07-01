class Solution {
    public int solution(int num) {
        int answer = 0;
        int copy = num;
        int count = 0;
        
        while(true) {
            if(copy==1) {
                return count;
            }
            if(count>500) break;
            if(copy%2==0) {
                copy = copy / 2;
            }
            else if(copy%2==1) {
                copy = copy * 3 + 1;       
            } 
            count++;
        }
        
        return -1;
    }
}