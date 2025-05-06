package Solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
    // 우선순위 큐 사용 => 효율성 검사 통과
    public static void main(String[] args) {
        int[] works = {4, 3, 3};
        int n = 4;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++){
            pq.offer(works[i]);
        }

        for(int i = 0 ; i < n ; i++){
            int max = pq.poll();
            pq.offer(max-1);
        }
        int answer = 0;

        for(int p : pq){
            answer += p * p;
        }

        if(answer < 0) {
            System.out.println(0);
        }
        System.out.println(answer);
    }
}

// 효율성 테스트 실패
//    public static void main(String[] args) {
//        int[] works = {1, 1};
//        int n = 3;
//
//        for(int i = 0 ; i < n ; i++){
//            int max = Integer.MIN_VALUE;
//            for(int j = 0 ; j < works.length ; j++){
//                max = Math.max(max, works[j]);
//            }
//            if(max == 0) {
//                System.out.println(0);
//                return;
//            }
//            System.out.println(max);
//            for(int j = 0 ; j < works.length ; j++){
//                if(max == works[j]){
//                    works[j] -= 1;
//                    break;
//                }
//            }
//        }
//
//        for(int a : works){
//            System.out.println(a + " ");
//        }
//        int answer = 0;
//
//        for(int i = 0 ; i < works.length ; i++){
//            answer += works[i] * works[i];
//        }
//        System.out.println(answer);
//
//    }
//}
