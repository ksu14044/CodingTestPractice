package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public static void main(String[] args) {
        String[][] clothes = {{"a", "b"}, {"c", "d"}, {"f", "b"}};
        Map<String, Integer> ootd = new HashMap<>();
        for(String[] cloth : clothes) {
            ootd.put(cloth[1], ootd.getOrDefault(cloth[1], 0) + 1);
        }
        int answer = 1;
        for(int a : ootd.values()) {
            answer *= a+1;
        }
        System.out.println(answer);
    }
}
