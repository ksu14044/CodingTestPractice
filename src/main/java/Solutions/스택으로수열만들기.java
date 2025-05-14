package Solutions;

import java.util.Stack;

public class 스택으로수열만들기 {
    public static void main(String[] args) {
        int[] arr = {4,1,6,8,7,5,2,1};
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        for(int i = 0 ; i < arr.length ; i++){
            int su = arr[i];
            if(num <= su){
                while(num <= su){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int m = stack.pop();
                if(m > su){
                    System.out.println("NO");
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
