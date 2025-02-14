import java.util.*;

class Server {
    int count;
    int makeTime;
    int endTime;
    boolean isEnd;
    
    public Server(int count, int makeTime, int endTime, boolean isEnd) {
        this.count = count;
        this.makeTime = makeTime;
        this.endTime = endTime;
        this.isEnd = isEnd;
    }
}

class Solution {
    static List<Server> serverList = new ArrayList<>();
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int playingServer = 0;
        
        for(int i=0; i<players.length; i++) {
            stopServer(i);
            playingServer = getPlayingServer();
            
            int player = players[i];
            int needServer = player / m;
            
            if(needServer != 0 && playingServer < needServer) {
                int increaseServerCount = (player / m) - playingServer;
                answer += increaseServerCount;
                serverList.add(new Server(increaseServerCount, i, i+k, false));
            }
            
            
        }
        return answer;
    }
    
    public int getPlayingServer() {
        int count = 0;
        for(Server s: serverList) {
            if(!s.isEnd) count += s.count;
        }
        
        return count;
    }
    
    public void stopServer(int time) {
        for(Server s: serverList) {
            if(time >= s.endTime) s.isEnd = true;
        }
    }
    
}