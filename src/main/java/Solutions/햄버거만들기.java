package Solutions;

import java.util.Stack;

public class 햄버거만들기 {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int ing : ingredient){
            stack.push(ing);
            if(stack.size() >= 4){
                int size = stack.size();
                if(stack.get(size - 4) == 1 &&
                    stack.get(size - 3) == 2 &&
                    stack.get(size - 2) == 3 &&
                        stack.get(size - 1) == 1){
                    for(int i = 0 ; i < 4 ; i++){
                        stack.pop();
                    }
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
