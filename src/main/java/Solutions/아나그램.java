package Solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String answer = "YES";

        Map<Character, Integer> map = new HashMap<>();

        for(char a : str1.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(char a : str2.toCharArray()) {
            if(!map.containsKey(a) || map.get(a) == 0) {
                answer = "NO";
                break;
            } else {
                map.put(a, map.get(a) - 1);
            }
        }

        System.out.println(answer);
    }
}