package Solutions;

import java.util.*;

public class 시소짝꿍 {
    public static void main(String[] args) {
        int[] weights = {100, 180, 360, 100, 270};
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int w : weights){
            answer += map.getOrDefault((double)w, 0);
            answer += map.getOrDefault(w * 2.0 / 3 , 0);
            answer += map.getOrDefault(w * 3.0 / 4 , 0);
            answer += map.getOrDefault(w * 2.0 / 4 , 0);
            map.put((double)w, map.getOrDefault((double)w, 0) +1);
        }
        System.out.println(answer);
    }
}
