package Solutions;

import java.util.PriorityQueue;

public class 구명보트 {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < people.length ; i++) {
            pq.add(people[i]);
        }
        int count = 0;
        while(!pq.isEmpty()) {
            int total = pq.poll();
            while(!pq.isEmpty() && total + pq.peek() <= limit ) {
                total += pq.poll();
            }
            count ++;
        }

        System.out.println(count);
    }
}
