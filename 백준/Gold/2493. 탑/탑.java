import java.io.*;
import java.util.*;

class 탑 {
    int index;
    int height;
    
    public 탑(int index, int height) {
        this.index = index;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws Exception{
        Stack<탑> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            int height = Integer.parseInt(st.nextToken());
            
            while(true) {
                if(stack.isEmpty()) {
                    sb.append("0").append(" ");
                    stack.push(new 탑(i+1, height));
                    break;
                }
                
                if(!stack.isEmpty()) {
                    탑 top = stack.peek();
                    
                    if(top.height < height) {
                        stack.pop();
                    }
                    
                    if(top.height >= height) {
                        sb.append(top.index).append(" ");
                        stack.push(new 탑(i+1, height));
                        break;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}

// 스택엔 항상 값을 쌓음. 다음 숫자가 들어올때 그 숫자보다 작은애들은 모두 버린다. 
// 탑은 왼쪽에서 레이저 쏘지만 코드로 짤때는 반대로 가고있음. 그러니까 현재 숫자와 스택을 비교하게되면
// 스택에 잇는 값이 나중에 내 레이저를 수신하는지 수신하지 못하는지를 판단함, 나보다 작은애들은 수신하지 못하니 나보다 큰 애들만 보면됨. 그리고 가장 먼저 만나게 된 큰 값이 내 레이저를 수신함.
// 뒤에 값은생각 안해도되는게 현재숫자보다 큰 값이면 현재숫자 버려질거고(스택에서 큰값 찾던가 못찾으면 0)