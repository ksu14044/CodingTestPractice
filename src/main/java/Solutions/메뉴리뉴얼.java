package Solutions;

import java.util.*;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        List<String> answer = new ArrayList<>();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        for(int c : course){
            Map<String, Integer> comboCount = new HashMap<>();
            for(String order : orders){
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                combination(comboCount, chars, new StringBuilder(), 0, c);
            }
            int max = 0;
            for(String m : comboCount.keySet()){
                if(comboCount.get(m) > max){
                    max = comboCount.get(m);
                }
            }
            if(max < 2) continue;
            for(String m : comboCount.keySet()){
                if(comboCount.get(m) == max){
                    answer.add(m);
                }
            }
        }
        Collections.sort(answer);


    }

    public static void combination(Map<String, Integer> map, char[] chars, StringBuilder sb, int start, int len){
        if(sb.length() == len){
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for(int i = start; i < chars.length ; i++){
            sb.append(chars[i]);
            combination(map, chars, sb, i+1, len);
            sb.deleteCharAt(sb.length()-1);
        }
    }


}
