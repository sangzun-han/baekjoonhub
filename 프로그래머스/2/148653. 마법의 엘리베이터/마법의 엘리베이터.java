class Solution {
    public int solution(int storey) {
        int answer = 0;
        int carry = 0;
        
        
        while(storey != 0) {
            int digit = storey % 10;
            storey = storey / 10;
            
            digit += carry;
            
            if(digit < 5) {
                answer += digit;
                carry = 0;
            } else if(digit > 5) {
                answer += (10 - digit);
                carry = 1;
            } else if (digit == 5) {
                if(storey % 10 >= 5) {
                    answer += (10 - digit);
                    carry = 1;
                } else {
                    answer += digit;
                    carry = 0;
                }
            }
        }
        
        if(carry > 0) answer += carry;
        return answer;
    }
}