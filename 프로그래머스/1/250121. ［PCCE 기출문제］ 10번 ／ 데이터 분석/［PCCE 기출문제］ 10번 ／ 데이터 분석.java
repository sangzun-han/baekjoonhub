import java.util.*;

class Solution {
    static class Data {
        int code;
        int date;
        int maximum;
        int remain;
        
        public Data(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<Data> list = new ArrayList<>();
        ArrayList<Data> filteredList = new ArrayList<>();
        
        for(int i=0; i<data.length; i++) {
            list.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
        }
        
        for(Data d: list) {
            if(ext.equals("date") && d.date < val_ext) {
                filteredList.add(d);
            } else if(ext.equals("code") && d.code < val_ext) {
                 filteredList.add(d);
            } else if(ext.equals("maximum") && d.maximum < val_ext) {
                 filteredList.add(d);
            } else if(ext.equals("remain") && d.remain < val_ext) {
                 filteredList.add(d);
            }
        }
        
        if (sort_by.equals("code")) {
            Collections.sort(filteredList, new Comparator<Data>() {
                @Override
                public int compare(Data d1, Data d2) {
                    return Integer.compare(d1.code, d2.code);
                }  
            });
        } else if (sort_by.equals("date")) {
            Collections.sort(filteredList, new Comparator<Data>() {
                @Override
                public int compare(Data d1, Data d2) {
                    return Integer.compare(d1.date, d2.date);
                }
            });
        } else if (sort_by.equals("maximum")) {
            Collections.sort(filteredList, new Comparator<Data>() {
                @Override
                public int compare(Data d1, Data d2) {
                    return Integer.compare(d1.maximum, d2.maximum);
                }
            });
        } else if (sort_by.equals("remain")) {
            Collections.sort(filteredList, new Comparator<Data>() {
                @Override
                public int compare(Data d1, Data d2) {
                    return Integer.compare(d1.remain, d2.remain);
                }
            });
        }
        
        int[][] answer = new int[filteredList.size()][4];
        
        for(int i=0; i<filteredList.size(); i++) {
            Data d = filteredList.get(i);
            answer[i][0] = d.code;
            answer[i][1] = d.date;
            answer[i][2] = d.maximum;
            answer[i][3] = d.remain;
        }
        
    
        return answer;
    }
}