package Solutions;

import java.util.Stack;

public class 뒤에있는큰수찾기 {
    public static void main(String[] args) {
        int[] numbers = {9,1,5,3,6,2};
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = numbers.length - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && stack.peek() <= numbers[i]){
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }
        for(int a : answer){
            System.out.println(a);
        }




    }
}
