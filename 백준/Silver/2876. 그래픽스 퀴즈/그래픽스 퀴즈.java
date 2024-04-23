import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] grades = new int[N+1][6]; //grades[i][j] I번째 책상까지 고려했을때 등급 j가 연속해서 나타나는 최대 길이

        int maxStudent = Integer.MIN_VALUE;
        int maxGrade = Integer.MIN_VALUE;

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            grades[i][A] = grades[i-1][A]+1;
            if(grades[i][A] > maxStudent) {
                maxStudent = grades[i][A];
                maxGrade = A;
            } else if (grades[i][A] == maxStudent && A < maxGrade) {
                maxGrade = A;
            }
            if(A!=B) {
                grades[i][B] = grades[i-1][B]+1;
                if(grades[i][B] > maxStudent) {
                    maxStudent = grades[i][B];
                    maxGrade = B;
                } else if (grades[i][B] == maxStudent && B < maxGrade) {
                    maxGrade = B;
                }
            }
        }

        System.out.println(maxStudent+" "+maxGrade);
    }
}
