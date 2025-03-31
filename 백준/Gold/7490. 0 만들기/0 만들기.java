import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] operation = new String[n-1];
            recursive(n, operation, 0);

            if (t < T - 1) sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void recursive(int n, String[] operation, int index) {
        if(n-1==index) {
            calc(operation,n);
            return;
        }


        operation[index] = " ";
        recursive(n, operation, index+1);
        operation[index] = "+";
        recursive(n, operation, index+1);
        operation[index] = "-";
        recursive(n, operation, index+1);
    }

    private static void calc(String[] operation, int n) {
        int sum = 0;
        char signed = '+';
        int current = 1;

        for(int i=0; i<operation.length; i++) {
            int next = i + 2;
            String op = operation[i];

            if(op.equals(" ")) {
                current = current * 10 + next;
            } else {
                if(signed== '+') sum += current;
                else sum -= current;

                signed = op.charAt(0);
                current = next;
            }
        }
        if(signed=='+') sum += current;
        else sum -= current;

        if(sum==0) {
            for(int i=0; i<operation.length; i++) {
                sb.append(i+1);
                sb.append(operation[i]);
            }
            sb.append(n).append("\n");
        }
    }
}
