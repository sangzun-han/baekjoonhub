import java.util.*;

class Ticket implements Comparable<Ticket>{
    String airport;
    boolean isVisited;
    
    Ticket(String airport, boolean isVisited) {
        this.airport = airport;
        this.isVisited = isVisited;
    }
    
    @Override
    public int compareTo(Ticket t) {
        return airport.compareTo(t.airport);
    }
}

class Solution {
    static Map<String, PriorityQueue<Ticket>> ticketMap = new HashMap<>();
    static LinkedList<String> answerList = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        
        for(String[] ticket: tickets) {
            String start = ticket[0];
            String to = ticket[1];
            PriorityQueue<Ticket> pq = ticketMap.getOrDefault(start, new PriorityQueue<Ticket>());
            pq.offer(new Ticket(to, false));
            ticketMap.put(start, pq);
        }
        
        dfs("ICN");
        
        String[] answer = new String[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    public void dfs(String ticket) {
        PriorityQueue<Ticket> pq = ticketMap.get(ticket);
        
        while(pq != null && !pq.isEmpty()) {
            Ticket t = pq.poll();
            dfs(t.airport);
        }
        
        answerList.addFirst(ticket);
    }
}
