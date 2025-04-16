class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1;

        m = convertSharp(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            int start = toMinutes(parts[0]);
            int end = toMinutes(parts[1]);
            String title = parts[2];
            String sheet = convertSharp(parts[3]);
            int playTime = end - start;

            StringBuilder played = new StringBuilder();
            for (int i = 0; i < playTime; i++) {
                played.append(sheet.charAt(i % sheet.length()));
            }

            if (played.toString().contains(m)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    private int toMinutes(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    private String convertSharp(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b");
    }
}
