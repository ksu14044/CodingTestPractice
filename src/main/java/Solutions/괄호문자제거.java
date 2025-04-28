package Solutions;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x == ')') {
                while(stack.pop() != '(');
            }
            else { stack.push(x); }
        }
        for(int i = 0 ; i < stack.size() ; i++) {
            answer += stack.get(i);
        }
        System.out.println(answer);
    }
}
