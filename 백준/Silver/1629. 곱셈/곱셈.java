import java.io.*;
import java.util.*;

public class Main {
    static long A,B,C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(divide(A,B));
    }

    private static long divide(long num, long exp) {
        if(exp==1) return num%C;
        long temp = divide(num,exp/2);
        if(exp%2==0) return (temp%C * temp%C);
        else return (temp%C * temp%C * num%C);
    }
}