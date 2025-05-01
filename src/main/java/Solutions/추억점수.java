package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 추억점수 {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}
        };
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < name.length ; i++){
            map.put(name[i], yearning[i]);
        }
        int[] ans = new int[photo.length];
        for(int i = 0 ; i < photo.length ; i++){
            int sum = 0;
            for(int j = 0 ; j < photo[i].length ; j++){
                sum += map.getOrDefault(photo[i][j], 0);
            }
            ans[i] = sum;
        }
        for(int a : ans){
            System.out.println(a);
        }
    }
}
