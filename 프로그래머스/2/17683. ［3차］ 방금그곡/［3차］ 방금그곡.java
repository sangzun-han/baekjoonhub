import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        StringBuilder sb = new StringBuilder();
        String answer = "(None)";
        int maxPlayTime = 0;
        m = convertMelody(m);
        
        for(int i=0; i<musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            int startTime = convertTime(info[0]);
            int endTime = convertTime(info[1]);
            String title = info[2];
            String music = convertMelody(info[3]);
            
            int playingTime = endTime - startTime;
            
            for(int j=0; j<playingTime; j++) {
                sb.append(music.charAt(j % music.length()));
            }
            
            String playedMusic = sb.toString();
            sb.setLength(0);
            
            if(playedMusic.contains(m)) {
                if(playingTime > maxPlayTime) {
                    maxPlayTime = playingTime;
                    answer = title;
                }
            }
            
        }
        
        return answer;
    }
    
    public int convertTime(String time) {
        String[] timeSplit = time.split(":");
        int hour = Integer.parseInt(timeSplit[0]);
        int minute = Integer.parseInt(timeSplit[1]);
        
        return hour * 60 + minute;
    }
    
    public String convertMelody(String melody) {
        String replaceMelody = melody.replace("C#","z")
            .replace("D#","x")
            .replace("F#","v")
            .replace("G#","w")
            .replace("A#","q")
            .replace("B#","m");
        
        return replaceMelody;
    }
}