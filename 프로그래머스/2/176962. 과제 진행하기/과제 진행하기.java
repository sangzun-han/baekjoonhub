import java.util.*;

class Homework implements Comparable<Homework>{
    String name;
    int startTime;
    int playTime;
    
    public Homework(String name, int startTime, int playTime) {
        this.name = name;
        this.startTime = startTime;
        this.playTime = playTime;
    }
    
    @Override
    public int compareTo(Homework h) {
        return this.startTime - h.startTime;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        PriorityQueue<Homework> plan = new PriorityQueue<>();
        Stack<Homework> wait = new Stack<>();
        
        List<String> answerList = new ArrayList<>();
        
        for(int i=0; i<plans.length; i++) {
            String name = plans[i][0];
            int startTime = convertTime(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            plan.offer(new Homework(name, startTime, playTime));
        }
        
        Homework current = plan.poll();
        int currentTime = current.startTime;
        
        while(!plan.isEmpty()) {
            Homework next = plan.peek();
            // 과제를 바로 끝낼 수 있음.
            if(next.startTime >= currentTime + current.playTime) {
                answerList.add(current.name);
                currentTime += current.playTime;
                            
                while(!wait.isEmpty()) {
                    Homework waiting = wait.pop();
                    
                    if(currentTime + waiting.playTime <= next.startTime) {
                        answerList.add(waiting.name);
                        currentTime += waiting.playTime;
                    } else {
                        waiting.playTime -= next.startTime - currentTime;
                        wait.push(waiting);
                        break;
                    }
                }
                
                current = plan.poll();
                currentTime = Math.max(current.startTime, currentTime);                
            } else {
                current.playTime -= next.startTime - currentTime;
                wait.push(current);    
                current = plan.poll();
                currentTime = next.startTime;
            }
        }
   
        answerList.add(current.name);

        
        while(!wait.isEmpty()) {
            Homework waiting = wait.pop();
            answerList.add(waiting.name);
        }
        
        String[] answer = new String[answerList.size()];
        
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public int convertTime(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]) * 60;
        int minute = Integer.parseInt(t[1]);
        return hour + minute;
    }
}