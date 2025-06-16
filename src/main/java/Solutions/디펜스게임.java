package Solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class 디펜스게임 {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        System.out.println(solution(n, k, enemy));
    }

    public static int solution(int n, int k , int[] enemy){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int round = 0;
        for(int i = 0 ;i < enemy.length; i++){
            pq.offer(enemy[i]);
            n -= enemy[i];
            if(n < 0){
                if(k > 0){
                    int max = pq.poll();
                    n += max;
                    k--;
                } else break;
            }
            round++;
        }
        return round;
    }
}
