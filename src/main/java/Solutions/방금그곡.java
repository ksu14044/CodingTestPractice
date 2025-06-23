package Solutions;

public class 방금그곡 {
    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = -1;

        m = convertMelody(m);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] parts = musicinfos[i].split(",");
            int start = getMinutes(parts[0]);
            int end = getMinutes(parts[1]);
            int playTime = end - start;

            String title = parts[2];
            String melody = convertMelody(parts[3]);

            StringBuilder playedMelody = new StringBuilder();
            for (int j = 0; j < playTime; j++) {
                playedMelody.append(melody.charAt(j % melody.length()));
            }

            if (playedMelody.toString().contains(m)) {
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    // C#을 c 등으로 변환
    private static String convertMelody(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b")
                .replaceAll("E#", "e");
    }

    // HH:MM -> 분 변환
    private static int getMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
