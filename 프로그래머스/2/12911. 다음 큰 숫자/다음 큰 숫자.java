class Solution {
    public int solution(int n) {
        int answer = 0;
        String nBinary = Integer.toBinaryString(n);
        int nCount = nBinary.replace("0","").trim().length();
    
        
        for(int next=n+1; next<=1_000_000; next++) {
            String binary = Integer.toBinaryString(next);
            int nextCount = binary.replace("0","").trim().length();
            if(nCount==nextCount) {
                answer = next;
                break;
            }
        }
        
        return answer;
    }
}

// 1. 주어진 n보다 더 크다

// 2. 이진수로 변환했을때 1의 개수가 같다.

// 3. 1,2를 만족하면서 가장 작은 수다.


// 1) n부터 반복을 시작한다.
// 2) 이진수로 변환을 해본다. Integer.toBinaryString() 메소드 사용.
// 3) 0을 모두 제거한다. replace. trim 사용
// 4) 길이가 같다면 정답
// 5) 다르다면 다음반복으로;