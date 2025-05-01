import java.io.*;
import java.util.*;

class Team implements Comparable<Team>{
    int teamId;
    int[] scores;
    int submitCount;
    int lastSubmitTime;
    int sum;
    
    Team(int teamId, int problemNo) {
        this.teamId = teamId;
        this.scores = new int[problemNo + 1];
        this.sum = 0;
        this.submitCount = 0;
        this.lastSubmitTime = 0;
    }
    
    @Override
    public int compareTo(Team t) {
        if(this.sum == t.sum && this.submitCount==t.submitCount) return this.lastSubmitTime - t.lastSubmitTime;
        if(this.sum == t.sum) return this.submitCount - t.submitCount;
        return t.sum - this.sum;
    }   
}

public class Main {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀갯수
            int k = Integer.parseInt(st.nextToken()); // 문제갯수
            int t = Integer.parseInt(st.nextToken()); // 내 팀 id
            int m = Integer.parseInt(st.nextToken()); // 로그엔트리 개수
            
            Map<Integer, Team> map = new HashMap<>();
            
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int id  = Integer.parseInt(st.nextToken());
                int no = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                
           
                Team team = map.get(id);
                
                if(team == null) {
                    team = new Team(id, k);
                    map.put(id, team);
                } 
                
                if (team.scores[no] < score) {
                    team.sum += (score - team.scores[no]);
                    team.scores[no] = score;
                }
                
                team.submitCount++;
                team.lastSubmitTime = i;
            }
       
            List<Team> list = new ArrayList<>(map.values());
            Collections.sort(list);

            for(int i=0; i<list.size(); i++) {
                if(list.get(i).teamId == t) {
                    sb.append(i+1).append("\n");
                    break;
                }
            }
            
        }
        System.out.print(sb.toString());
    }
}
