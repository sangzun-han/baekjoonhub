import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        
        int redBall = 0;
        int blueBall = 0;

     
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'R') redBall++;
            else blueBall++;
        }

        int frontRed = 0;
        int frontBlue = 0;
        
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'R') frontRed++;
            else break;
        }
        
        for (int i = 0; i < N; i++) {
            if (balls.charAt(i) == 'B') frontBlue++;
            else break;
        }

        int backRed = 0;
        int backBlue = 0;
        
        for (int i = N - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'R') backRed++;
            else break;
        }
        
        for (int i = N - 1; i >= 0; i--) {
            if (balls.charAt(i) == 'B') backBlue++;
            else break;
        }

        int result = Math.min(blueBall - Math.max(frontBlue, backBlue), redBall - Math.max(frontRed, backRed));
        System.out.println(result);
    }
}
