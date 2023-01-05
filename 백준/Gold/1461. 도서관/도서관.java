import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
       // 절대 값이 가장 큰거는 나중에 방문
        // 그 외 M개만큼 먼곳부터

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x>=0) pos.add(x);
            else neg.add(x);
        }

        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg);

        int ans = 0;
        int posIdx = 0;
        int negIdx = 0;

        int minus = 0;
        if(pos.size()>0 && neg.size()>0) {
            minus = Math.max(pos.get(0), Math.abs(neg.get(0)));
        } else if (pos.size()>0) {
            minus = pos.get(0);
        } else if (neg.size()>0) {
            minus = Math.abs((neg.get(0)));
        }

        while(posIdx<pos.size()) {
            int temp = pos.get(posIdx);

            for(int i=0; i<M; i++) {
                if(posIdx==pos.size()) break;
                posIdx++;
            }

            ans += temp*2;
        }


        while(negIdx<neg.size()) {
            int temp = neg.get(negIdx);
            for(int i=0; i<M; i++) {
                if(negIdx==neg.size()) break;
                negIdx++;
            }

            ans += Math.abs(temp*2);
        }

        System.out.println(ans - minus);
    }
}