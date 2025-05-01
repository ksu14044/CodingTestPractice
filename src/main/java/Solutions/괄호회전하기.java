package Solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        int answer = 0;
        String s = "}]()[{";
        String[] splitS = s.split("");
        Queue<String> q = new LinkedList<>();
        for(String a : splitS){
            q.offer(a);
        }

        for(int i = 0 ; i < splitS.length ; i++){
            for(int j = 0 ; j < 1 ; j++){
                q.offer(q.poll());
            }
            System.out.println(q);

            String[] check = new String[splitS.length];

            for(int k = 0 ; k < splitS.length ; k++){
                String temp = q.poll();
                check[k] = temp;
            }

            if(isOk(check)){
                answer++;
            }

            for(int p = 0 ; p < splitS.length ; p++){
                q.offer(check[p]);
            }
        }
        System.out.println(answer);

    }
    public static boolean isOk(String[] check) {
        Stack<Character> stack = new Stack<>();
        for (String s : check) {
            char c = s.charAt(0);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
