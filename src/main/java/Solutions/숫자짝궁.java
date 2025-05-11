package Solutions;

import java.util.*;

public class 숫자짝궁 {
    public static void main(String[] args) {
        String X = "12321";
        String Y = "42531";
        Map<String, Integer> mapX = new HashMap<>();
        Map<String, Integer> mapY = new HashMap<>();
        for(String x : X.split("")){
            mapX.put(x, mapX.getOrDefault(x, 0) + 1);
        }
        for(String y : Y.split("")){
            mapY.put(y, mapY.getOrDefault(y, 0) + 1);
        }

        Map<String, Integer> result = new HashMap<>();
        for(String s : mapX.keySet()){
            if(mapY.get(s) != null){
                result.put(s, Math.min(mapX.get(s), mapY.get(s)));
            }
        }

        List<Integer> list = new ArrayList<>();
        for(String s : result.keySet()){
            for(int i = 0 ; i < result.get(s) ; i++){
                list.add(Integer.parseInt(s));
            }
        }
        list.sort(Collections.reverseOrder());


        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < list.size(); i++){
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());

    }
}
