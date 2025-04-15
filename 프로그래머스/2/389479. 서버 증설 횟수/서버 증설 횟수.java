import java.util.*;

class Server {
    int startTime;
    int endTime;
    boolean isEnd;
    
    Server(int startTime, int endTime, boolean isEnd) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isEnd = isEnd;
    }
}

class Solution {
    static List<Server> serverList = new ArrayList<>();
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        
        for(int i=0; i<players.length; i++) {
            int currentTime = i+1;
            int player = players[i];
            exitServer(currentTime);
            int playingServerCount = useServer();
            int needServerCount = player / m;
            int need = playingServerCount - needServerCount;            
            if(need < 0) {
                answer += Math.abs(need);
                for(int j=0; j<Math.abs(need); j++) {
                    serverList.add(new Server(currentTime, currentTime + k, false));
                }
            }
          
        }
        return answer;
    }
    
    public void exitServer(int time) {
        for(Server server: serverList) {
            if(server.endTime <= time) {
                server.isEnd = true;
            }
        }
    }
    
    public int useServer() {
        int count = 0;
        
        for(Server server: serverList) {    
            // System.out.println(server.startTime+" "+server.isEnd);
            if(server.isEnd==false) {
                count++;
            }
        }
        
        return count;
    }
}



