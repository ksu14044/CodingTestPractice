package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크자르기 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int answer = 0;
        Map<Integer, Integer> a = new HashMap<>();
        for(int t : topping){
            a.put(t, a.getOrDefault(t, 0) + 1);
        }
        Map<Integer, Integer> b = new HashMap<>();
        for(int t : topping){
            System.out.println("a:" + a);
            System.out.println("b:" + b);
            b.put(t, b.getOrDefault(t, 0) + 1);
            a.replace(t, a.get(t) - 1);
            if(a.get(t) == 0){
                a.remove(t);
            }
            if(a.size() == b.size()){
                answer++;
            }
        }


        System.out.println(answer);


    }
}
