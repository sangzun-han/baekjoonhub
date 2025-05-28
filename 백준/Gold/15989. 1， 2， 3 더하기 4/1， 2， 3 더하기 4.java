import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        int SIZE = 10001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] d = new int[SIZE];
        d[0] = 1;
        
        for(int i=1; i<=3; i++) {
            for(int j=i; j<SIZE; j++) {
                d[j] += d[j-i];
            }
        }
        
        
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }
}


/**
먼저 1을 쓸 수 있는 모든 경우를 고려해채움
그다음 2를 쓸 수 있는 경우를 추가함 (단, 이미 이전에 1을 쓴 경우는 그대로 있음)
마지막으로 3을 추가한 경우를 누적
→ 자연스럽게 1+2와 2+1은 같은 조합으로 만들어짐 (앞에서 이미 1+2만 만들어짐, 2+1은 나오지 않음)

📌 예시: n = 4
초기 상태: d[0] = 1, 나머지 0

🔹 i = 1
모든 수는 1만 사용 가능


d[1] += d[0] → d[1] = 1  → [1]
d[2] += d[1] → d[2] = 1  → [1+1]
d[3] += d[2] → d[3] = 1  → [1+1+1]
d[4] += d[3] → d[4] = 1  → [1+1+1+1]

i = 2
d[2] += d[0] → d[2] = 2  → [2] 추가됨
d[3] += d[1] → d[3] = 2  → [1+2] (중복 X)
d[4] += d[2] → d[4] = 3  → [1+1+2] 포함됨

i=3
d[3] += d[0] → d[3] = 3  → [3] 추가됨
d[4] += d[1] → d[4] = 4  → [1+3] 추가됨
*/
