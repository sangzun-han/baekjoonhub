class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder();
        
        int videoLength = secondFromTime(video_len);
        int currentPos = secondFromTime(pos);
        int opStart = secondFromTime(op_start);
        int opEnd = secondFromTime(op_end);
        
        for(int i=0; i<commands.length; i++) {
            if(currentPos >= opStart && currentPos <= opEnd) {
                currentPos = opEnd;
            }
            
            if(commands[i].equals("prev")) {
                if(currentPos < 10) {
                    currentPos = 0;
                } else {
                    currentPos -= 10;
                }
                
                if(currentPos >= opStart && currentPos <= opEnd) {
                    currentPos = opEnd;
                }
            } else if(commands[i].equals("next")) {
                if(videoLength - currentPos < 10) {
                    currentPos = videoLength;
                } else {
                    currentPos += 10;
                }
                
                if(currentPos >= opStart && currentPos <= opEnd) {
                    currentPos = opEnd;
                }   
            }
        }
        String mm = Integer.toString(currentPos / 60);
        String ss = Integer.toString(currentPos - Integer.parseInt(mm)*60);


        if(mm.length()==1) {
            sb.append(0).append(mm);
        } else {
            sb.append(mm);
        }
        sb.append(":");
        if(ss.length()==1) {
            sb.append(0).append(ss);
        } else {
            sb.append(ss);
        }
        return sb.toString();
    }
    
    private int secondFromTime(String time) {
        int second = 0;
        String[] s = time.split(":");
        second = Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]);
        
        return second;
    }
}

    
    