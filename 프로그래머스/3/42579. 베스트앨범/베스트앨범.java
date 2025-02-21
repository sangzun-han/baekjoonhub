import java.util.*;

class Song implements Comparable<Song>{
    int plays;
    int num;
    
    Song(int plays, int num) {
        this.plays = plays;
        this.num = num;
    }
    
    @Override
    public int compareTo(Song s) {
        if(this.plays == s.plays) return this.num - s.num;
        return s.plays - this.plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Song>> genresMap = new HashMap<>();        
        Map<String, Integer> genresToPlay = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        
        int len = plays.length;
        
        for(int i=0; i<len; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            List<Song> song = genresMap.getOrDefault(genre, new ArrayList<>());
            song.add(new Song(play, i));
            genresMap.put(genre, song);
            
            genresToPlay.put(genre, genresToPlay.getOrDefault(genre, 0) + play);
 
        }
        
        // 1. 많이 재생된 장르 순
        List<Map.Entry<String,Integer>> sortedGenres = new ArrayList<>(genresToPlay.entrySet());
        sortedGenres.sort((a,b) -> b.getValue() - a.getValue());
        
        for(int i=0; i<sortedGenres.size(); i++) {
            String genre = sortedGenres.get(i).getKey();
            List<Song> song = genresMap.get(genre);
            Collections.sort(song);
            
            for(int j=0; j<song.size(); j++) {
                if(j==2) break;
                answerList.add(song.get(j).num);
            }
        }
  
        int[] answer = new int[answerList.size()];
        
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}