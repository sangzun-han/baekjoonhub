import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i+1);
        }

        while (true) {
            if (list.size() == 1) break;

            for (int i = list.size()-1; i>=0; i--) {
                if (i % 2 == 0) {
                     index.add(i);
                }
            }

            for(int idx: index) {
                list.remove(idx);
            }
            index.clear();
        }
        System.out.println(list.get(0));


    }
}


