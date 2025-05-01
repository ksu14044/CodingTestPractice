package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {
                "chicken", "apple", "apple", "banana", "rice", "apple", "pork",
                "banana", "pork", "rice", "pot", "banana", "apple", "banana"
        };

        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < want.length ; i++){
            map.put(want[i], number[i]);
        }
        System.out.println("map: " + map);

        for(int i = 0 ; i <= discount.length - 10 ; i++){
            Map<String, Integer> checkMap = new HashMap<>();
            for(int j = i ; j < i + 10 ; j++) {
                checkMap.put(discount[j], checkMap.getOrDefault(discount[j], 0)+1);
            }
            System.out.println("checkMap: " + checkMap);
            if(checkMap.equals(map)){
                count ++;
            }
            checkMap.clear();
        }

        System.out.println(count);
    }
}
