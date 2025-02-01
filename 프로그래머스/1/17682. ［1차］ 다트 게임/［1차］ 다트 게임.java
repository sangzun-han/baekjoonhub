class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int index = -1;
        for(int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            
            if(Character.isDigit(c)) {
                // 숫자가 등장했으면 새로운 기회
                index++;
                
                // 10이 나옴
                if(c=='1' && i+1 < dartResult.length() && dartResult.charAt(i+1) == '0') {
                    score[index] = 10;
                    // 10을 처리했으니 i를 증가시켜서 0은 만나지 못하도록함
                    i++;
                } else {
                    score[index] = c - '0';
                }
                
            }
            else if(c=='S') {
                score[index] = score[index];   
            } else if(c=='D') {
                score[index] = score[index] * score[index];
            } else if (c=='T') {
                score[index] = score[index] * score[index] * score[index];
            }
            
            else if(c=='*') {
                if(index - 1 >= 0) {
                     score[index-1] = score[index-1] * 2;
                }
                score[index] = score[index] * 2;
               
            } else if (c=='#') {
                score[index] = score[index]*-1;
            }
        }
     
        return score[0] + score[1] + score[2];
    }
}