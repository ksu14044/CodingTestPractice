package Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 큰수만들기 {
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;
        String[] splits = number.split("");
        Stack<Integer> stack = new Stack<>();
        int deletedCount = 0;
        for(int i = 0 ; i < splits.length ; i++){
            if(stack.isEmpty()){
                stack.push(Integer.parseInt(splits[i]));
                continue;
            }
            while(!stack.isEmpty() &&stack.peek() < Integer.parseInt(splits[i]) && deletedCount < k){
                stack.pop();
                deletedCount++;
            }
            stack.push(Integer.parseInt(splits[i]));

        }
        while (k > deletedCount) {
            stack.pop();
            deletedCount++;
        }
        List<String> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(String.valueOf(stack.pop()));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = list.size()-1 ; i >= 0 ; i--){
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());

    }
}
