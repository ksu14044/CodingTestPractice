package Solutions;

import java.util.*;

public class 보석쇼핑 {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        Set<String> check = new HashSet<>();
        for(String s : gems){
            check.add(s);
        }
        int checkSize = check.size();
        Map<String, Integer> map = new HashMap<>();

        int lt = 0; int rt = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while(map.size() < checkSize && rt < gems.length){
            map.put(gems[rt], map.getOrDefault(gems[rt], 0) + 1);
            rt++;
            while(map.size() == checkSize){
                if(rt - lt < minLen){
                    minLen = rt - lt;
                    answer[0] = lt+1;
                    answer[1] = rt;
                }
                map.put(gems[lt], map.get(gems[lt]) - 1);
                if(map.get(gems[lt]) == 0){
                    map.remove(gems[lt]);
                }
                lt++;
            }
        }
        System.out.println(map);
        System.out.println(Arrays.toString(answer));
    }
}
