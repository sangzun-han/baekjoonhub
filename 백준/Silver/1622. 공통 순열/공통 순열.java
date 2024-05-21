import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            char[] a = sc.nextLine().toCharArray();
            char[] b = sc.nextLine().toCharArray();
            Map<Character, Integer> L = new HashMap<>();
            Map<Character, Integer> R = new HashMap<>();
            ArrayList<Character> list = new ArrayList<>();

            for(char c: a) {
                L.put(c, L.getOrDefault(c,0)+1);
            }

            for(char c: b) {
                R.put(c, R.getOrDefault(c,0)+1);
            }

            for(char c: L.keySet()) {
                if(R.containsKey(c)) {
                    int count = Math.min(L.get(c), R.get(c));
                    while(count-->0) {
                        list.add(c);
                    }
                }
            }

            Collections.sort(list);
            for(char c: list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
