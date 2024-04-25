import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static int[] nums;
    static int numLength;
    static String maxNumber;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[K];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<K; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        numLength = String.valueOf(N).length();
        list = new ArrayList<>();

        perm("",0);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
    }

    private static void perm(String cur, int cnt) {
        if(cur.length() > numLength) return;
        if(!cur.isEmpty() && Integer.parseInt(cur) <= N) {

            if(cur.length() <= numLength) {
                list.add(Integer.parseInt(cur));
                maxNumber = cur;
            }
        }

        for(int num: nums) {
            perm(cur+num, cnt+1);
        }
    }
}
