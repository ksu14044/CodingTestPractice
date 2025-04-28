package Solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 귤고르기 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1,3,2,5,4,5,2,3};
        int total = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        System.out.println(map);
        int[] list = map.values().stream().mapToInt(i -> i).toArray();
        Arrays.sort(list);
        for(int a : list) {
            System.out.println(a);
        }
        for(int i = list.length - 1; i >= 0; i--){
            if(total + list[i] < k) {
                total += list[i];
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
