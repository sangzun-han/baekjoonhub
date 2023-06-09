class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int same = 0;
        
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i]==0) zero++;
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i]==win_nums[j]) same++;
            }
        }
        
        switch (same+zero) {
            case 6:
                answer[0] = 1;
                break;
            case 5:
                answer[0] = 2;
                break;
            case 4:
                answer[0] = 3;
                break;
            case 3:
                answer[0] = 4;
                break;
            case 2:
                answer[0] = 5;
                break;
            default:
                answer[0] = 6;
                
        }
        
         switch (same) {
            case 6:
                answer[1] = 1;
                break;
            case 5:
                answer[1] = 2;
                break;
            case 4:
                answer[1] = 3;
                break;
            case 3:
                answer[1] = 4;
                break;
            case 2:
                answer[1] = 5;
                break;
            default:
                answer[1] = 6;
        }
        
        return answer;
    }
}