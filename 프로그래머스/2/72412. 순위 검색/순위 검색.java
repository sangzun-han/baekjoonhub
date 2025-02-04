import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[query.length];
        Map<String, List<Integer>> infoMap = new HashMap<>();
        
        for(String s: info) {
            String[] splitInfo = s.split(" ");
            String 언어 = splitInfo[0];
            String 직군 = splitInfo[1];
            String 경력 = splitInfo[2];
            String 소울푸드 = splitInfo[3];
            int 점수 = Integer.parseInt(splitInfo[4]);
            sb.append(언어).append(" ").append(직군).append(" ").append(경력).append(" ").append(소울푸드);
            String key = sb.toString();
            List<Integer> list = infoMap.get(key);
            if(list==null) {
                list = new ArrayList<>();
                infoMap.put(key, list);
            }
            list.add(점수);
            infoMap.put(key, list);
            sb.setLength(0);
        }
        
        for(List<Integer> scores: infoMap.values()) {
            Collections.sort(scores);
        }
        
       
        int index = 0;       
        for(String q: query) {
            int count = 0;
            
            List<String> languages = new ArrayList<>();
            List<String> types = new ArrayList<>();
            List<String> histories = new ArrayList<>();
            List<String> foods = new ArrayList<>();
            
            String[] queryInfo = q.split("and");
            String 언어 = queryInfo[0].trim();
            if(언어.equals("-")) {
                languages.add("cpp");
                languages.add("java");
                languages.add("python");
            } else {
                languages.add(언어);
            }
           
            String 직군 = queryInfo[1].trim();
            
            if(직군.equals("-")) {
                types.add("backend");
                types.add("frontend");
            } else {
                types.add(직군);
            }
            
            String 경력 = queryInfo[2].trim();
            
            if(경력.equals("-")) {
                histories.add("junior");
                histories.add("senior");
            } else {
                histories.add(경력);
            }
            
            String[] foodAndScore = queryInfo[3].split(" ");

            String 소울푸드 = foodAndScore[1];
            

            if(소울푸드.equals("-")) {
                foods.add("pizza");
                foods.add("chicken");
            } else {
                foods.add(소울푸드);
            }
            
            int 점수 = Integer.parseInt(foodAndScore[2]);
            for(String language: languages) {
                for(String type: types) {
                    for(String history: histories) {
                        for(String food: foods) {
                            sb.append(language).append(" ").append(type).append(" ").append(history).append(" ").append(food);
                            String key = sb.toString();
                            sb.setLength(0);
                            List<Integer> findScore = infoMap.get(key);
                            if(findScore==null) continue;
                            int idx = Collections.binarySearch(findScore,점수);
                            if(idx < 0) {
                                idx = -idx - 1;
                            } else {
                                while(idx > 0 && findScore.get(idx-1) == 점수) {
                                    idx--;
                                }
                            }

                            count += findScore.size() - idx;
                            
                           
                
                        }
                    }
                }
            }
         answer[index++] = count;
        }
       
       
        return answer;
    }
}