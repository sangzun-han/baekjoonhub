import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] op;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        recursive(1, nums[0], op[0], op[1], op[2], op[3]);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int n: list) {
            if(n>max) max = n;
            if(n<min) min = n;
        }
        System.out.println(max);
        System.out.println(min);
    }

    private static void recursive(int index, int cur, int plus, int minus, int mul, int div) {
        if(index==N) {
            list.add(cur);
            return;
        }

        if(plus>0) recursive(index+1, cur+nums[index], plus-1, minus, mul, div);
        if(minus>0) recursive(index+1, cur-nums[index], plus, minus-1, mul, div);
        if(mul>0) recursive(index+1, cur*nums[index], plus, minus, mul-1, div);
        if(div>0) recursive(index+1, cur/nums[index], plus, minus, mul, div-1);

    }
}