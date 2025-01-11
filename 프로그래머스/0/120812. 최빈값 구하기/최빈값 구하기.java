class Solution {
    public int solution(int[] array) {
        int[] check= new int[1001];
        
        // 값 몇개 나왔는지 체크
        for(int i=0; i<array.length; i++) {
            check[array[i]]++;
        }
        
        int max = -1;
        int index = -1;
        
        for(int i=0; i<check.length; i++) {
            if(check[i] > max) {
                max = check[i];
                index = i;
            }
        }
        
        for(int i=0; i<check.length; i++) {
            if(max == check[i] && i !=index) {
                return -1;
            }
        }
        
        return index;
    }
}