package Solutions;

import java.util.*;

class 무지의먹방라이브 {
    public static void main(String[] args) {
        int[] food_times = {3,1,2};
        long k = 5;
        System.out.println(solution(food_times, k));
    }
    public static int solution(int[] food_times, long k){
        int n = food_times.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i = 0 ; i < n ; i++){
            pq.offer(new int[]{food_times[i], i+1});
        }
        long prev = 0;
        long foodCount = n;
        while(!pq.isEmpty()){
            long timeGap = pq.peek()[0] - prev;
            long consume = timeGap * foodCount;
            if(k >= consume){
                k -= consume;
                prev = pq.peek()[0];
                while(!pq.isEmpty() && pq.peek()[0] == prev){
                    pq.poll();
                    foodCount--;
                }
            } else {
                List<int[]> result = new ArrayList<>(pq);
                Collections.sort(result, Comparator.comparingInt(a -> a[1]));
                return result.get((int) (k % foodCount))[1];
            }
        }
        return -1;
    }
}
// k가 너무 큼 >> 시간초과
//class Solution {
//    public int solution(int[] food_times, long k) {
//        int answer = 0;
//        Queue<int[]> q = new LinkedList<>();
//        for(int i = 0 ; i < food_times.length ; i++){
//            q.offer(new int[]{food_times[i], i+1});
//        }
//        for(long i = 0 ; i < k ; i++){
//            int[] cur = q.poll();
//            cur[0]--;
//            if(cur[0] > 0){
//                q.offer(cur);
//            }
//        }
//        return q.isEmpty() ? -1 : q.poll()[1];
//    }
//}