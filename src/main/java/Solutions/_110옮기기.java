package Solutions;

import java.util.Arrays;
import java.util.Stack;

public class _110옮기기 {
    public static void main(String[] args) {
        String[] s = {"1110","100111100","0111111010"};
        String[] answer = new String[s.length];
        for(int i = 0 ; i < s.length ; i++){
            answer[i] = transform(s[i]);
        }
        System.out.println(Arrays.toString(answer));
    }
    public static String transform(String str){
        Stack<Character> stack = new Stack<>();
        int count110 = 0;
        for(char c : str.toCharArray()){
            stack.add(c);
            if(stack.size() >= 3){
                char third = stack.pop();
                char second = stack.pop();
                char first = stack.pop();
                if(first == '1' && second == '1' && third == '0'){
                    count110++;
                } else {
                    stack.add(first);
                    stack.add(second);
                    stack.add(third);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        int insertPos = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                insertPos = i + 1;
                break;
            }
        }
        StringBuilder result = new StringBuilder(sb);
        while (count110-- > 0) {
            result.insert(insertPos, "110");
        }
        return result.toString();
    }
}
