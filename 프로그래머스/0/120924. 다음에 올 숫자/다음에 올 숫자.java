class Solution {
    public int solution(int[] common) {
        boolean 등차수열 = false;
        boolean 등비수열 = false;
        int answer = 0;
        if((common[1] - common[0]) == (common[2] - common[1])) {
            등차수열 = true;
        } else {
            등비수열 = true;
        }
           
        if(등차수열) {
            int 공차 = common[1] - common[0];
            answer = common[common.length-1] + 공차;
        }
           
        if(등비수열) {
            int 공비 = common[1] / common[0];
            answer = common[common.length-1] * 공비;
        }
        
        return answer;
    }
}