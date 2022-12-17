import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> crane = new ArrayList<>();

        for(int i=0; i<N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        List<Integer> box = new ArrayList<>();

        for(int i=0; i<M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        // 박스의 크기가 크레인보다 커버리면 넣을수없으니까 -1 출력하고 끝냄
        if(crane.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int ans = 0;
        // 크레인에 박스를 넣을 수 있다면 박스 삭제
        while(!box.isEmpty()) {
            int idx = 0;
            for(int i=0; i<N; i++) {
                if(idx >= box.size()) break;
                if(crane.get(i) >= box.get(idx)) {
                    box.remove(idx);
                }
                else {
                    // i는 반복을 통해서 계속 증가하므로 i--를 통해 크레인을 원래대로 idx는 다음 박스
                    idx++;
                    i--;
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
}