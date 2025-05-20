import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Character> used = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            boolean assigned = false;

            // 1단계: 각 단어의 첫 글자 시도
            for (int j = 0; j < words.length; j++) {
                char c = Character.toLowerCase(words[j].charAt(0));
                if (!used.contains(c)) {
                    used.add(c);
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    assigned = true;
                    break;
                }
            }

            // 문자열 재조합
            String result = String.join(" ", words);

            // 2단계: 전체 문자열 왼쪽부터 탐색
            if (!assigned) {
                for (int j = 0; j < result.length(); j++) {
                    char c = Character.toLowerCase(result.charAt(j));
                    if (c == ' ') continue;
                    if (!used.contains(c)) {
                        used.add(c);
                        result = result.substring(0, j) + "[" + result.charAt(j) + "]" + result.substring(j + 1);
                        break;
                    }
                }
            }

            System.out.println(result);
        }
    }
}
