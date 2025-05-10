package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 대충만든자판 {
    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        Map<Character, Integer> keys = new HashMap<>();

        for(String key : keymap){
            char[] chars = key.toCharArray();
            for(int i = 0 ; i < chars.length ; i++){
                keys.put(chars[i], Math.min(keys.getOrDefault(chars[i], i+1), i+1));
            }
        }

        List<Integer> answer = new ArrayList<>();
        String[] targets = {"ABCD","AABB"};
        for(String target : targets){
            int sum = 0;
            char[] chars = target.toCharArray();
            for(int i = 0 ; i < chars.length ; i++){
                if(keys.containsKey(chars[i])){
                    sum += keys.get(chars[i]);
                } else {
                    sum = -1;
                    break;
                }
            }
            answer.add(sum);
        }
        System.out.println(answer);

    }
}
