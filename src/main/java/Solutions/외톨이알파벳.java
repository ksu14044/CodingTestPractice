package Solutions;

import java.util.*;

public class 외톨이알파벳 {
    public static void main(String[] args) {
        String input_string = "edeaaabbccd";
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] isc = input_string.toCharArray();
        for(int i = 0 ; i < isc.length; i ++){
            List<Integer> indexes = new ArrayList<>();
            for(int j = 0 ; j < isc.length; j++){
                if(isc[j] == isc[i]) indexes.add(j);
            }
            map.put(isc[i], indexes);
        }
        List<Character> answer = new ArrayList<>();
        for(char c : map.keySet()){
            List<Integer> indexes = map.get(c);
            for(int i = 0 ; i < indexes.size() - 1 ; i++){
                if(indexes.get(i) != indexes.get(i+1) - 1){
                    if(!answer.contains(c)){
                        answer.add(c);
                    }
                }
            }
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(char c : answer){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
