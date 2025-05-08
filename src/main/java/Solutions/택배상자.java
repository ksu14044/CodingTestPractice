package Solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args) {
        int[] order = {5, 4, 3, 2, 1};
        int lt = 0;
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Stack<Integer> s = new Stack<>();
        for(int i = 1 ; i <= order.length; i++){
            q.offer(i);
        }

        while(!q.isEmpty()){
            int a = q.poll();
            if(a != order[lt]){
                s.push(a);
            } else {
                answer++;
                lt++;
                while(!s.isEmpty()){
                    int b = s.peek();
                    if(b == order[lt]){
                        s.pop();
                        answer++;
                        lt++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
