package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 겹치는선분의길이 {
    public static void main(String[] args) {
        int[][] lines = {{0,1},{2,5},{3,9}};
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] line : lines){
            for(int i = line[0] ; i < line[1] ; i++){
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        int answer = 0;
        for(int a : map.keySet()){
            if(map.get(a) >= 2){
                answer ++;
            }
        }
        System.out.println(answer);

    }
}
