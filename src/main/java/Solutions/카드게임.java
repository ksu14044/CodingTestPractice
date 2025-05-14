package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class 카드게임 {
    public static void main(String[] args) {
        int n = 6;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            q.offer(i);
        }

        while(q.size() > 1){
            q.poll();
            q.offer(q.poll());
        }
        System.out.println(q.poll());
    }
}
