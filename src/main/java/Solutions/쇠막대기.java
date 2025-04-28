package Solutions;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < chars.length ; i++) {
            if(chars[i] == '(') {
                stack.push(chars[i]);
            } else if(chars[i] == ')') {
                if(chars[i-1] == '('){
                    stack.pop();
                    answer += stack.size();
                } else if(chars[i-1] == ')') {
                    stack.pop();
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
