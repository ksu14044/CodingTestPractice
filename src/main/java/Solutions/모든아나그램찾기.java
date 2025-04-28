package Solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 모든아나그램찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        모든아나그램찾기 main = new 모든아나그램찾기();

        int lt = 0;
        int cnt = 0;

        for(int i = 0 ; i < str1.length() - str2.length() + 1 ; i++) {
            String divided = str1.substring(i, i + str2.length());
            if(main.anagram(str2, divided)) {
                cnt++;
            }
        }
        System.out.println(cnt);


    }

    public boolean anagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char a : s.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(char a : t.toCharArray()) {
            if(!map.containsKey(a) || map.get(a) == 0) {
                return false;
            } else {
                map.put(a, map.get(a) - 1);
            }
        }
        return true;
    }
}

