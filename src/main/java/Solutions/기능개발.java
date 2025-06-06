package Solutions;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1,1,1,1,1,1};
        int n = progresses.length;
        int[] dayLeft = new int[n];
        for(int i = 0 ; i < n ; i++){
            dayLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        int maxDay = dayLeft[0];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(dayLeft[i] <= maxDay){
                count++;
            } else {
                q.offer(count);
                maxDay = dayLeft[i];
                count = 1;
            }
        }
        q.add(count);
        int[] answer = q.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(answer));
    }
}
//    public static void main(String[] args) {
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1,1,1,1,1,1};
//
//        for(int i = 0 ;i < progresses.length; i++) {
//            progresses[i] = 100 - progresses[i];
//            if(progresses[i] % speeds[i] == 0) {
//                progresses[i] = progresses[i] / speeds[i];
//            } else {
//                progresses[i] = progresses[i] / speeds[i] + 1;
//            }
//        }
//        System.out.println("1" + Arrays.toString(progresses));
//
//        for(int i = 1 ;i < progresses.length;i++) {
//            if(progresses[i] < progresses[i-1]) {
//                progresses[i] = progresses[i-1];
//            }
//        }
//        System.out.println("2" + Arrays.toString(progresses));
//
//        Queue<Integer> queue = new PriorityQueue<>();
//        for(int i = 0 ;i < progresses.length;i++) {
//            queue.add(progresses[i]);
//        }
//        int count = 1;
//        List<Integer> list = new ArrayList<>();
//        while(!queue.isEmpty()) {
//            if(queue.poll().equals(queue.peek()) ) {
//                count++;
//            } else {
//                list.add(count);
//                count = 1;
//            }
//        }
//
//        System.out.println(list);
//
//    }
//}
