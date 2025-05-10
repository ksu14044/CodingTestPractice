package Solutions;

import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.add(i);
        }
        int count = 0;
        while(!pq.isEmpty()){
            int n = pq.poll();
            if(n >= K) break;
            try{
                int m = pq.poll();
                pq.add(n + m*2);
                count++;
            } catch(NullPointerException e){
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}
