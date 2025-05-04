package Solutions;

import java.util.HashMap;
import java.util.Map;

public class 뉴스클러스트링 {
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";
        char[] str1Chars = str1.toLowerCase().toCharArray();
        char[] str2Chars = str2.toLowerCase().toCharArray();
        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();

        for(int i = 0 ; i < str1Chars.length - 1 ; i++){
            if(Character.isAlphabetic(str1Chars[i]) && Character.isAlphabetic(str1Chars[i+1])){
                String str = String.valueOf(str1Chars[i]) + String.valueOf(str1Chars[i+1]);
                str1Map.put(str, str1Map.getOrDefault(str, 0) + 1);
            }
        }
        for(int i = 0 ; i < str2Chars.length - 1 ; i++){
            if(Character.isAlphabetic(str2Chars[i]) && Character.isAlphabetic(str2Chars[i+1])){
                String str = String.valueOf(str2Chars[i]) + String.valueOf(str2Chars[i+1]);
                str2Map.put(str, str2Map.getOrDefault(str, 0) + 1);
            }
        }
        System.out.println(str1Map);
        System.out.println(str2Map);
        Map<String, Integer> andMap = new HashMap<>();
        for(String s : str1Map.keySet()){
            andMap.put(s, Math.min(str1Map.get(s), str2Map.getOrDefault(s, 0)));
        }
        System.out.println(andMap);

        Map<String, Integer> orMap = new HashMap<>();
        for(String s : str1Map.keySet()){
            orMap.put(s, str1Map.get(s));
        }
        for(String s2 : str2Map.keySet()){
            if(orMap.get(s2) != null){
                orMap.replace(s2, Math.max(str1Map.getOrDefault(s2, 0), str2Map.get(s2)));
            } else {
                orMap.put(s2, str2Map.get(s2));
            }
        }
        int and = andMap.values().stream().reduce(0, Integer::sum);
        int or =  orMap.values().stream().reduce(0, Integer::sum);
        if(or == 0) System.out.println(65536);
        float result = (float) and / or * 65536;
        System.out.println((int) result);
    }
}
