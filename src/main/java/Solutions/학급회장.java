package Solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 학급회장 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char answer = ' ';
        String str = sc.next();
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = str.toCharArray();
        for(char c : ch) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        System.out.println(answer);
    }
}
