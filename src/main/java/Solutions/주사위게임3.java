package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 주사위게임3 {
    public static void main(String[] args) {
        int a = 6, b = 4, c = 2, d = 5;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);

        int answer = Integer.MAX_VALUE;
        if(map.size()==1){
            answer = a * 1111;
        } else if (map.size()==2){
            if( map.get(a) == 3 || map.get(a) == 1) {
                answer = threePOneQ(map);
            } else if (map.get(a) == 2) {
                answer = twoPTwoQ(map);
            }
        } else if (map.size() == 3){
            answer = twoPOneQOneR(map);
        } else if (map.size() == 4){
            for(int key : map.keySet()){
                answer = Math.min(answer, key);
            }
        }
        System.out.println(answer);
    }

    static int threePOneQ (Map<Integer, Integer> map){
        int p = 0;
        int q = 0;
        for(int key : map.keySet()){
            if(map.get(key) == 3){
                p = key;
            } else if(map.get(key) == 1){
                q = key;
            }
        }
        return (10 * p + q) * (10 * p + q);
    }

    static int twoPTwoQ (Map<Integer, Integer> map){
        int p = 0;
        int q = 0;
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            list.add(key);
        }
        p = list.get(0);
        q = list.get(1);
        return (p + q) * Math.abs(p - q);
    }

    static int twoPOneQOneR (Map<Integer, Integer> map){

        int q = 0;
        int r = 0;
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                list.add(key);
            }
        }
        q = list.get(0);
        r = list.get(1);
        return q * r;
    }
}
