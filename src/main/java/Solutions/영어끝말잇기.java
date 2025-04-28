package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] answer = {0, 0};
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < words.length ; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) +1);
            if(map.get(words[i]) > 1) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                System.out.println(answer[0] + " " + answer[1]);
                return;
            }
        }
        for(int i = 0 ; i < words.length-1 ; i++){
            char last = words[i].charAt(words[i].length()-1);
            char start = words[i+1].charAt(0);
            System.out.println(last + " " + start + " " + i);
            if(last != start) {
                answer[0] = (i+1) % n + 1;
                answer[1] = (i+1) / n + 1;
                System.out.println(answer[0] + " " + answer[1]);
                return;
            }
        }
    }
}
