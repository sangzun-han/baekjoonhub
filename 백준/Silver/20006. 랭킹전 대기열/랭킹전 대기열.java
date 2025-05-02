import java.io.*;
import java.util.*;

class Player implements Comparable<Player>{
    int level;
    String nickname;
    int initPlayerLevel;
    
    Player(int level, String nickname, int initPlayerLevel) {
        this.level = level;
        this.nickname = nickname;
        this.initPlayerLevel = initPlayerLevel;
    }
    
    @Override
    public int compareTo(Player p) {
        return this.nickname.compareTo(p.nickname);
    }
}

public class Main {
    static Map<Integer, List<Player>> rooms = new HashMap<>();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        makeRooms(p);

        for(int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            
            // 매칭 하러 ㄱㄱ
            matchPlayer(level, nickname, m);              
         }
        
          for(int key: rooms.keySet()) {
                List<Player> players = rooms.get(key);
                
                if(players.size()==0) continue;
                Collections.sort(players);
                
                if(players.size()==m) {
                    System.out.println("Started!");
                    for(Player player: players) {
                        System.out.println(player.level+" "+player.nickname);
                    }
                } else {
                    System.out.println("Waiting!");
                    for(Player player: players) {
                        System.out.println(player.level+" "+player.nickname);
                    }
                }
               
            }
    }
    
    public static void makeRooms(int p) {
        for(int i=0; i<p; i++) {
            rooms.put(i+1, new ArrayList<>());
        }
    }
    
    public static void matchPlayer(int level, String nickname, int m) {
        first:for(int key: rooms.keySet()) {
            List<Player> players = rooms.get(key);
            
            // 방에 이미 사람이 있음.
            if(players.size() != 0) {
                // 이미 인원 가득참 다음 방으로
                if(players.size() >= m) continue;
                
                // 방에 인원 추가 가능함 -> 레벨범위 확인.
                for(Player player: players) {
                    if(player.initPlayerLevel != 0) {
                        // 범위안에 들어온다 넣고 끝
                        if(player.initPlayerLevel-10<=level && player.initPlayerLevel+10>=level) {
                            players.add(new Player(level, nickname ,0));
                            return;
                        }
                    }
                }
            }
            // 먼저 만나는 null은 이 사람이 최초 입장하는 사람
            // 넣고 걍 Return;
            if(players.size()==0) {
                players.add(new Player(level, nickname, level));
                return;
            }
        }
    }
    
}