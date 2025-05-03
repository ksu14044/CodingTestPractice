package Solutions;

public class 옹알이 {
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String b : babbling) {
            int idx = 0;
            String previous = "";
            boolean valid = true;

            while (idx < b.length()) {
                boolean found = false;
                for (String w : words) {
                    if (b.startsWith(w, idx)) { // 특정 위치에서 시작하는지 확인
                        if (previous.equals(w)) { // 연속 발음 방지
                            valid = false;
                            break;
                        }
                        previous = w;
                        idx += w.length(); // 해당 단어 길이만큼 인덱스 이동
                        found = true;
                        break;
                    }
                }
                if (!found) break; // 허용된 단어가 아니면 종료
            }

            if (valid && idx == b.length()) answer++; // 완전한 변환 확인
        }
        System.out.println(answer);



    }
}
