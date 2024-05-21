import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[N];


        for (int i = 1; i < N; i++) {
            int minScore = score[i];
            int maxScore = score[i];
            for (int j = i; j >= 0; j--) {
                minScore = Math.min(minScore, score[j]);
                maxScore = Math.max(maxScore, score[j]);
                if (j == 0) {
                    dp[i] = Math.max(dp[i], maxScore - minScore);
                } else {
                    dp[i] = Math.max(dp[i], dp[j - 1] + maxScore - minScore);
                }
            }
        }


        System.out.println(dp[N - 1]);
    }
}
