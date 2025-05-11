package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    public static void main(String[] args) {
        int[] queue1 = {3,2,7,2};
        int[] queue2 = {4,6,5,1};
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0, totalSum = 0;
        for(int i = 0 ; i < queue1.length ; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        totalSum = sum1 + sum2;
        long average = totalSum / 2;
        int count = 0;
        int maxOperation = queue1.length *3;

        while(count < maxOperation){
            if(sum1 == average) {
                System.out.println(count);
                return;
            }
            if(sum1 > average) {
                count++;
                int value = q1.poll();
                sum1 -= value;
                q2.offer(value);
            } else if(sum1 < average){
                count++;
                int value = q2.poll();
                sum1 += value;
                q1.offer(value);
            }
        }


    }
}
