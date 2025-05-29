package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static void main(String[] args) {
         String[] participants = {"leo", "kiki", "eden"};
         String[] completion = {"kiki", "eden"};
         String answer = "";
         Map<String, Integer> map = new HashMap<>();
         for(String c : completion) map.put(c, map.getOrDefault(c, 0) + 1);
         for(String p : participants){
             if(map.getOrDefault(p, 0) == 0){
                 answer = p;
             } else {
                 map.put(p, map.get(p) - 1);
             }
         }
        System.out.println(answer);
    }
}
