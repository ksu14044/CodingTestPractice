package Solutions;

import java.util.ArrayDeque;
import java.util.Queue;

public class 요세푸스문제 {
    public static void main(String[] args) {
        int N = 5;
        int K = 2;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while(q.size() > 1){
            for(int i = 0 ; i < K - 1 ; i++){
                q.add(q.poll());
            }
            q.poll();
        }
        System.out.println(q.poll());
    }
}
