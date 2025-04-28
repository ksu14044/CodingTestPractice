package Solutions;

import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char a : str.toCharArray()) {
            if(a == '('){ stack.push(a); }
            else {
                if(stack.isEmpty()){
                    answer = "NO";
                } else { stack.pop(); }
            }
        }
        if(!stack.isEmpty()){
            answer = "NO";
        }

        System.out.println(answer);
//        Map<Character, Integer> map = new HashMap<>();
//        String answer = "YES";
//        map.put('(', 1);
//        map.put(')', 1);
//        for(char c : str.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//            if(map.get(')') > map.get('(')) {
//                answer = "NO";
//            }
//        }
//        if(map.get('(') != map.get(')')) {
//            answer = "NO";
//        }
//        System.out.println(answer);
    }
}
